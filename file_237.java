    private void createTable(String database, String table)
    {
        while (true) {
            try {
                client.createTable(database, table);
                LOG.info("Created table. database={}, table={}", database, table);
                return;
            }
            catch (TDClientHttpException e) {
                switch (e.getStatusCode()) {
                    case 409:
                        LOG.info("The table already exists. database={}, table={}", database, table);
                        return;
                    case 401:
                    case 403:
                        throw new NonRetryableException(
                                String.format("Failed to create table. database=%s, table=%s", database, table), e);
                    case 404:
                        createDatabase(database);
                        // Retry to create the table
                        break;
                    default:
                        throw new RetryableException(
                                String.format("Failed to create table. database=%s, table=%s", database, table), e);
                }
            }
            catch (NonRetryableException e) {
                throw e;
            }
            catch (Throwable e) {
                throw new RetryableException(
                        String.format("Failed to create table. database=%s, table=%s", database, table), e);
            }
        }
    }
    private void postGetConnectionHandling(Connection conn) throws SQLException {
        helper.doConnectionSetup(conn);

        String[] sqlCommands = dsConfig.get().onConnect;
        if (sqlCommands != null && sqlCommands.length > 0)
            onConnect(conn, sqlCommands);

        // Log the database and driver versions on first getConnection.
        if (!wasUsedToGetAConnection) {
            // Wait until after the connection succeeds to set the indicator.
            // This accounts for the scenario where the first connection attempt is bad.
            // The information needs to be read again on the second attempt.
            helper.gatherAndDisplayMetaDataInfo(conn, this);
            wasUsedToGetAConnection = true;
        }
    }
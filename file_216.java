    @Override
    protected Void doInBackground(String... arg0) {

        act.printSampleStartInfo("TableBasics");

        try {
            // Setup the cloud storage account.
            CloudStorageAccount account = CloudStorageAccount
                    .parse(MainActivity.storageConnectionString);

            // Create a table service client.
            tableClient = account.createCloudTableClient();

            // Retrieve a reference to a table.
            // Append a random UUID to the end of the table name so that this
            // sample can be run more than once in quick succession.
            table = tableClient.getTableReference(tableName
                    + UUID.randomUUID().toString().replace("-", ""));

            // Create the table if it doesn't already exist.
            table.createIfNotExists();

            // Illustrates how to list the tables.
            this.BasicListing();

            // Illustrates how to form and execute a single insert operation.
            this.BasicInsertEntity();

            // Illustrates how to form and execute a batch operation.
            this.BasicBatch();

            // Illustrates how to form and execute a query operation.
            this.BasicQuery();

            // Illustrates how to form and execute an upsert operation.
            this.BasicUpsert();

            // Illustrates how to form and execute an entity delete operation.
            this.BasicDeleteEntity();

            // Delete the table.
            table.deleteIfExists();

        } catch (Throwable t) {
            act.printException(t);
        }

        act.printSampleCompleteInfo("TableBasics");

        return null;
    }
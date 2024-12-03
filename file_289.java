    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        // init logging
        PropertyConfigurator.configure(
                IdxWritingExample.class.getResource(PACKAGE + "/log4j.properties"));

        // create some CSV records
        List<IdxRecord> records = new ArrayList<>();
        records.add(createRecord());
        records.add(createRecord());
        records.add(createRecord());
        records.add(createRecord());

        // write CSV records into a java.io.File
        try {
            write(records, File.createTempFile("output-", ".csv"));
        } catch (IOException ex) {
            LOGGER.error("Can't create temporary file!");
            LOGGER.error("> " + ex.getLocalizedMessage(), ex);
            System.exit(1);
        }

        // write CSV records into a java.io.OutputStream
        write(records, new NullOutputStream());

        // write CSV records into a java.io.Writer
        write(records, new NullWriter());

        // write CSV records into a string and send it to the console
        writeToConsole(records);
    }
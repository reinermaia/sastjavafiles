    public void csv(String file) throws IOException {
        CsvWriteOptions options = CsvWriteOptions.builder(file).build();
        new CsvWriter().write(table, options);
    }
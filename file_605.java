    private void openWriter() throws IOException {

        if (csvWriter == null) {
            csvWriter = new CSVWriter(new java.io.FileWriter(file), separator);
        }
    }
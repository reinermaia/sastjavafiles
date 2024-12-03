  private static byte[] writeCsv(String[] columnHeaders, String[][] rows) throws IOException {
    try (ByteArrayOutputStream csvStream = new ByteArrayOutputStream(); OutputStreamWriter streamWriter = new OutputStreamWriter(csvStream, Charset.forName("UTF-8"))) {
      CSVWriter csvWriter = new CSVWriter(streamWriter, ',');

      csvWriter.writeNext(columnHeaders);
      
      for (String[] row : rows) {
        csvWriter.writeNext(row);
      }

      csvWriter.close();
      
      return csvStream.toByteArray();
    }
  }
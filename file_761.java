  public void writeToCsv(
      DataRequest dataRequest, OutputStream outputStream, char separator, boolean noQuotes)
      throws IOException {
    try (CsvWriter csvWriter = new CsvWriter(outputStream, separator, noQuotes)) {
      csvWriter.setEntityWriteMode(getEntityWriteMode(dataRequest.getEntityValues()));
      String entityTypeId = dataRequest.getEntityName();
      writeCsvHeaders(dataRequest, csvWriter);
      csvWriter.add(dataService.findAll(entityTypeId, dataRequest.getQuery()));
    }
  }
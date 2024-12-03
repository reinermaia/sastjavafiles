  public static void writeCsv(List<String[]> csvData, String fileName) throws IOException {
    Preconditions.checkNotNull(csvData, "Null CSV data");
    Preconditions.checkNotNull(fileName, "Null file name");

    CSVWriter writer = null;
    try {
      writer = new CSVWriter(Files.newWriter(new File(fileName), StandardCharsets.UTF_8));
      for (String[] line : csvData) {
        writer.writeNext(line);
      }
    } finally {
      if (writer != null) {
        writer.close();
      }
    }
  }
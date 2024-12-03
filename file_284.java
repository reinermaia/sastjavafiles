  public static Properties readPropertiesFromFile(File file)
      throws IOException {
    try (FileInputStream fis = new FileInputStream(file)) {
      Properties prop = new Properties();
      prop.load(fis);
      return prop;
    }
  }
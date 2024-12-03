  private static int toInt(String str, int defaultVal) {
    try {
      return Integer.parseInt(str.trim());
    } catch (Exception e) {
      return defaultVal;
    }
  }
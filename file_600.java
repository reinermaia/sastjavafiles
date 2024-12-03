  private static int toInt(String v) {
    return v == null ? 1 : (int) MessageFormat.toLong(v, 0, v.length());
  }
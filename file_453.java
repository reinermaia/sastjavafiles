  private static Pattern regexToPatternOrNull(String regex) {
    if (regex != null && !regex.isEmpty() && !regex.equals(".*")) {
      return Pattern.compile(regex);
    }
    return null;
  }
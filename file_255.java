  @SuppressWarnings("unchecked")
  public static Map<String, String> parseCommandLineArguments(String[] args) {
    return (Map)parseCommandLineArguments(args, false);
  }
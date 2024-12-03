  public static File getExecutableLocation(final String exeName) {
    //
    // must add current working directory to the
    // from of the path from the "path" environment variable
    final File currentDir = new File(System.getProperty("user.dir"));
    if (new File(currentDir, exeName).exists()) {
      return currentDir;
    }
    final File[] envPath = CUtil.getPathFromEnvironment("PATH", File.pathSeparator);
    for (final File element : envPath) {
      if (new File(element, exeName).exists()) {
        return element;
      }
    }
    return null;
  }
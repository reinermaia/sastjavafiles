  private String getModuleExecutable(String modulePath) {
    String executable = executableName == null ? moduleName : executableName;
    return modulePath + File.separator + "bin" + File.separator + executable;
  }
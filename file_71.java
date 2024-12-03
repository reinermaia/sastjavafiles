    protected String getJavaExecutablePath() {
        String executableName = isWindows() ? "bin/java.exe" : "bin/java";
        return PROPERTIES.getJavaHome().resolve(executableName).toAbsolutePath().toString();
    }
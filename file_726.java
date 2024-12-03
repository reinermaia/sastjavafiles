    private static String javaCommand() {
        Path javaBinPath = Paths.get(System.getProperty("java.home"), "bin");
        File javaExecutable = javaBinPath.resolve("java").toFile();
        if (!javaExecutable.exists()) {
            javaExecutable = javaBinPath.resolve("java.exe").toFile();
        }
        return javaExecutable.getAbsolutePath();
    }
    public static Builder running(File executable) {
        checkArgument(executable.isFile(), "file not found: %s", executable);
        checkArgument(executable.canExecute(), "executable.canExecute");
        return running(executable.getPath());
    }
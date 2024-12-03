    public void setWorkingDirectory(String path) {
        if (path != null) {
            File dir = new File(path);
            checkWorkingDir(dir);
            workingDir = dir;
        } else {
            workingDir = null;
        }
    }
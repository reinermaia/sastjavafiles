    public void setWorkDir(String dir) throws IOException
    {
        File workDir = new File(dir);

        if (!workDir.exists() || !workDir.canWrite() || !workDir.canRead())
        {
            throw new IOException("Cannot access directory "+dir);
        }
        _workDir = workDir;
    }
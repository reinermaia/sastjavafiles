    @Override
    public final InputStream read(File file) throws LowlevelStorageException {
        //buffered reader?
        FileInputStream fileInputStream = null;
        {
            if (!file.exists()) {
                throw new LowlevelStorageException(true, "file "
                        + getPath(file) + "doesn't exist for reading");
            }
            if (!file.canRead()) {
                throw new LowlevelStorageException(true, "file "
                        + getPath(file) + "not readable");
            }

            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException eCaughtOpenFile) {
                throw new LowlevelStorageException(true,
                                                   "file "
                                                           + getPath(file)
                                                           + "couldn't be opened for reading",
                                                   eCaughtOpenFile);
            }
        }
        return fileInputStream;
    }
    public static void extractZip(File file) throws FileNotFoundException, IOException {
        final String originalPath = file.getPath();
        final File zip = new File(originalPath + ".zip");
        if (zip.isFile() && !zip.delete()) {
            LOGGER.debug("Failed to delete initial temporary file when extracting 'zip' {}", zip.toString());
            zip.deleteOnExit();
        }
        if (!file.renameTo(zip)) {
            throw new IOException("Unable to rename '" + file.getPath() + "'");
        }
        final File newFile = new File(originalPath);
        try (FileInputStream fis = new FileInputStream(zip);
                ZipInputStream cin = new ZipInputStream(fis);
                FileOutputStream out = new FileOutputStream(newFile)) {
            cin.getNextEntry();
            IOUtils.copy(cin, out);
        } finally {
            if (zip.isFile() && !org.apache.commons.io.FileUtils.deleteQuietly(zip)) {
                LOGGER.debug("Failed to delete temporary file when extracting 'zip' {}", zip.toString());
                zip.deleteOnExit();
            }
        }
    }
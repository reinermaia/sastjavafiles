    public static void unzip(File file, File destDir) throws IOException {
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(file));
        ZipEntry entry = zipIn.getNextEntry();
        // iterates over entries in the zip file
        while (entry != null) {
            File entryFile = new File(destDir, entry.getName());
            if (!entry.isDirectory()) {
                // if the entry is a file, extracts it
                extractFile(zipIn, entryFile);
            } else {
                // if the entry is a directory, make the directory
                entryFile.mkdir();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
    }
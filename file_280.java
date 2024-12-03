    private void extractOneFromZip(File srcFile, String entryName, File dstFile)
            throws IOException {

        try (ZipFile zipFile = new ZipFile(srcFile)) {
            Enumeration<? extends ZipEntry> enu = zipFile.entries();

            while (enu.hasMoreElements()) {
                ZipEntry zipEntry = enu.nextElement();

                if (zipEntry.getName().equals(entryName)) {

                    File parentDir = dstFile.getParentFile();
                    if (!parentDir.exists()) {
                        parentDir.mkdirs();
                    }

                    try (InputStream is = zipFile.getInputStream(zipEntry)) {
                        Files.copy(is, dstFile.toPath());
                    }
                }

            }
        }
    }
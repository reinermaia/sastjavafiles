    public static boolean testCompressedWARCFile(final File f)
    throws IOException {
        FileUtils.assertReadable(f);
        boolean compressed = false;
        final InputStream is = new FileInputStream(f);
        try {
            compressed = ArchiveUtils.isGzipped(is);
        } finally {
            is.close();
        }
        return compressed;
    }
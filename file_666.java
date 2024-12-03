    public static boolean testCompressedStream(final InputStream is)
    throws IOException {
        boolean compressedARCFile = false;
        try {
            new GzipHeader(is);
            compressedARCFile = true;
        } catch (NoGzipMagicException e) {
            return compressedARCFile;
        }
        return compressedARCFile;
    }
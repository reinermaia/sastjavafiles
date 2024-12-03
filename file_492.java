    InputStream getInputStream() throws IOException {
        switch (filetype) {
            case GZ:
                LOG.debug("Decompressing .gz file");
                return new GzipCompressorInputStream(new FileInputStream(compressedFile));
            case BZ2:
                LOG.debug("Decompressing .bz2 file");
                return new BZip2CompressorInputStream(new FileInputStream(compressedFile));
        }
        return null;
    }
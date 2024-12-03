    @Override
    public DocumentContext parse(File json) throws IOException {
        notNull(json, "json file can not be null");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(json);
            return parse(fis);
        } finally {
            Utils.closeQuietly(fis);
        }
    }
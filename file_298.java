    public static DocumentContext parse(File json, Configuration configuration) throws IOException {
        return new ParseContextImpl(configuration).parse(json);
    }
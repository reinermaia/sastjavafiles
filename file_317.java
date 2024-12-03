    public static BufferedReader newReader(Path self) throws IOException {
        return Files.newBufferedReader(self, Charset.defaultCharset());
    }
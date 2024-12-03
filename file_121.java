    public static String getText(Reader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        return getText(bufferedReader);
    }
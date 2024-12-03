    public Result<String> extractRawText(File file) throws IOException {
        return new InternalDocumentConverter(options).extractRawText(file).toResult();
    }
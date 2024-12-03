    public Result<String> convertToHtml(File file) throws IOException {
        return new InternalDocumentConverter(options).convertToHtml(file).toResult();
    }
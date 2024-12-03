    protected String createHtmlOverviewFile(File parentDir, List<TestReportHtml> htmls) throws IOException {
        return new HtmlOverviewFileWriter(parentDir).write(htmls);
    }
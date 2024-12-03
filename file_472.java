    public static HtmlPage toHtmlPage(String string) {
        try {
            URL url = new URL("http://bitvunit.codescape.de/some_page.html");
            return HTMLParser.parseHtml(new StringWebResponse(string, url), new WebClient().getCurrentWindow());
        } catch (IOException e) {
            throw new RuntimeException("Error creating HtmlPage from String.", e);
        }
    }
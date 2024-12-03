    public static HtmlPage toHtmlPage(WebDriver webDriver) {
        try {
            return HTMLParser.parseHtml(
                    new StringWebResponse(webDriver.getPageSource(), new URL(webDriver.getCurrentUrl())),
                    new WebClient().getCurrentWindow()
            );
        } catch (IOException e) {
            throw new RuntimeException("Error creating HtmlPage from WebDriver.", e);
        }
    }
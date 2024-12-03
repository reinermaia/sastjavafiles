    public HtmlElement findHtmlElementById(String elementId) {
        try {
            return htmlPage.getHtmlElementById(elementId);
        } catch (ElementNotFoundException e) {
            return null;
        }
    }
    public static String stripHtml(String html) {

        if (html == null) {
            return null;
        }
        Element el = DOM.createDiv();
        el.setInnerHTML(html);
        return el.getInnerText();
    }
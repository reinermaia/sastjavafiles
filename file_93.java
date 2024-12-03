    private static String removeHtmlMarkup(String html) {
        // replace any amount of white space with newline between through one
        // space
        html = html.replaceAll("\\s*[\\n]+\\s*", " ");
        // remove all valid html tags
        html = html.replaceAll("<[a-zA-Z]+>", "\n");
        html = html.replaceAll("</[a-zA-Z]+>", "");
        // convert some of the entities which are used in current FB
        // messages.xml
        html = html.replaceAll("&nbsp;", "");
        html = html.replaceAll("&lt;", "<");
        html = html.replaceAll("&gt;", ">");
        html = html.replaceAll("&amp;", "&");
        return html.trim();
    }
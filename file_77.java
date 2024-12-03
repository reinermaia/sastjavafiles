    private String getHtmlExample() {
        final StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n");
        html.append("<html xmlns=\"http://www.w3.org/1999/xhtml\"\n");
        html.append("      xmlns:h=\"http://xmlns.jcp.org/jsf/html\"\n");
        html.append("      xmlns:b=\"http://butterfaces.org/components\">\n");
        html.append("<h:head />\n");
        html.append("<body>\n");
        html.append("   <form>\n");
        html.append("      Hello World!\n");
        html.append("   </form>\n");
        html.append("</body>\n");
        html.append("</html>");

        return html.toString();
    }
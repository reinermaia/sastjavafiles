    public String getHtml() {
        String html;
        try {
            html = (String) executeJavascript(
                    "var node = document.doctype;\n" +
                            "var docType = '';\n" +
                            "if (node) {\n" +
                            "  docType = \"<!DOCTYPE \"\n" +
                            "+ node.name\n" +
                            "+ (node.publicId ? ' PUBLIC \"' + node.publicId + '\"' : '')\n" +
                            "+ (!node.publicId && node.systemId ? ' SYSTEM' : '') \n" +
                            "+ (node.systemId ? ' \"' + node.systemId + '\"' : '')\n" +
                            "+ '>'; }\n" +
                            "var html = document.documentElement.outerHTML " +
                            "|| '<html>' + document.documentElement.innerHTML + '</html>';\n" +
                            "return docType + html;"
            );
        } catch (RuntimeException e) {
            // unable to get via Javascript
            try {
                // this is very WebDriver implementation dependent, so we only use as fallback
                html = driver().getPageSource();
            } catch (Exception ex) {
                ex.printStackTrace();
                // throw original exception
                throw e;
            }
        }
        return html;
    }
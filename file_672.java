    public void toHTML(File file) throws IOException {
        PrintWriter out = new PrintWriter(file);

        out.printf("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"%s\"></head><body>\n", STYLE_URL);
        out.printf("<h1>%s</h1>%n", TITLE);
        out.println();
        out.println("<p>");
        out.printf("The URI for this vocabulary is <code>%s</code>. ", Constants.NAMESPACE);
        out.printf("When abbreviating terms the suggested prefix is <code>%s</code>. ", Constants.ABBREVIATION);
        out.printf("Each function in this function set has a URI constructed by appending a term name to the vocabulary URI. For example <code>%s</code>. ", functions.get(0).uri.stringValue());
        out.print("There are machine readable function description using <a href=\"http://www.ldodds.com/schemas/sparql-extension-description/\">SPARQL Extension Description Vocabulary]</a> in ");
        out.printf("<a href=\"%s\">RDF/XML</a> and <a href=\"%s\">TURTLE</a>.", LINK_XML, LINK_TURTLE);
        out.println("</p>");
        for(FunctionDoc.Reference reference : FunctionDoc.Reference.values()) {
            for (FunctionDoc.Type type : FunctionDoc.Type.values()) {

                boolean show = false;
                //test if it should be displayed
                for (Function function : functions) {
                    if (function.reference == reference && function.typeName.equals(type.getName()) && function.type.equals(type.getUri())) {
                        show = true; break;
                    }
                }

                if(!show) continue;

                out.printf("<h2>%s %ss</h2>", reference.getName(), type.getName());
                out.println("<table>");
                out.println("<tr><th>Relation name</th><th>Description</th>");
                for (Function function : functions) {
                    if (function.reference == reference && function.typeName.equals(type.getName()) && function.type.equals(type.getUri()))

                        out.printf("<tr><td>%s:%s( %s )</td><td>%s</td>\n", Constants.ABBREVIATION, function.uri.stringValue().substring(Constants.NAMESPACE.length()), function.getPropertyString(", ","<i>","</i>"), function.description);
                }
                out.println("</table>");
            }
        }

        out.flush();
        out.close();
    }
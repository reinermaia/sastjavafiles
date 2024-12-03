    private void printFieldsArrayTableHeader(String[] fieldsArray, PrintWriter html) {
        html.append("<center><table width=\"90%\" border=\"1\" cellpadding=\"5\" cellspacing=\"5\" bgcolor=\"silver\">\n"
                + "<tr>");
        for (String element : fieldsArray) {
            html
            .append("<td valign=\"top\"><strong>");
            html.append(element);
            html.append("</strong></td>");
        }
        html.append("</tr>");
    }
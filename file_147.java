    public void printHtmlFooter(PrintWriter out, ResourceBundle reg)
    {
        String strHTML = reg.getString("htmlFooter");
        if ((strHTML == null) || (strHTML.length() == 0))
            strHTML = "</body>\n</html>";
        out.println(strHTML);
        out.flush();
    }
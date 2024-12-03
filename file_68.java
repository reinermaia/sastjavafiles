    private String getHtmlForPDFConversion() throws IOException {
        StringBuilder oldContent = new StringBuilder();

        FileReader fr = new FileReader(file);
        try (BufferedReader reader = new BufferedReader(fr)) {
            String line;
            while ((line = reader.readLine()) != null) {
                oldContent.append(line);
                oldContent.append("\r\n");
            }
        }

        // replace all non convertible elements with empty text or modify for conversion
        String str = oldContent.toString()
                .replaceAll("<script type='text/javascript'>(?s).*</script>", "")
                .replaceAll("<tr>\\s*<th>View Results</th>(?s).*?</tr>", "")
                .replaceAll("&nbsp;", " ");

        String imagePattern = "(<img(?s).*? src='(.*?)'(?s).*?)</img>";
        Pattern r = Pattern.compile(imagePattern);
        Matcher m = r.matcher(str);
        int imageCount = 0;
        while (m.find()) {
            str = str.replaceFirst("<a href='javascript:void\\(0\\)'(?s).*?(<img(?s).*? src='(.*?)'(?s).*?)" +
                            " style(?s).*?</img>",
                    "<a href=\"#image-" + imageCount + "\">View Screenshot</a>");
            str = str.replaceFirst("</body>", "<p style='page-break-before: always' id='image-" + imageCount++ + "'></p" +
                    ">" +
                    m.group().replaceAll("width='300px' style(?s).*?'>", "height='600px' width='1000px'>") + "</body>");
        }
        return str;
    }
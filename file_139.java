    public String extract(String html, CETR.Parameters parameters) {
        html = clearText(html); //preprocess the Document by removing irrelevant HTML tags and empty lines and break the document to its lines
        List<String> rows = extractRows(html); //
        
        List<Integer> selectedRowIds = selectRows(rows, parameters);
        
        StringBuilder sb = new StringBuilder(html.length());
        for(Integer rowId : selectedRowIds) {
            String row = rows.get(rowId);
            
            //extract the clear text from the selected row
            row = StringCleaner.removeExtraSpaces(HTMLParser.extractText(row));
            if(row.isEmpty()) {
                continue;
            }
            sb.append(row).append(" ");
        }
        
        return sb.toString().trim();
    }
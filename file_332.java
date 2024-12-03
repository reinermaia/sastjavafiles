    public String getCsv() {

        StringWriter writer = new StringWriter();
        try (CSVWriter csv = new CSVWriter(writer)) {
            List<String> headers = new ArrayList<>();
            for (String col : m_columns) {
                headers.add(col);
            }
            csv.writeNext(headers.toArray(new String[] {}));
            for (List<Object> row : m_data) {
                List<String> colCsv = new ArrayList<>();
                for (Object col : row) {
                    colCsv.add(String.valueOf(col));
                }
                csv.writeNext(colCsv.toArray(new String[] {}));
            }
            return writer.toString();
        } catch (IOException e) {
            return null;
        }
    }
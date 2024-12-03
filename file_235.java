    private String listToCSV(List<String> list) {
        String csvStr = "";
        for (String item : list) {
            csvStr += "," + item;
        }

        return csvStr.length() > 1 ? csvStr.substring(1) : csvStr;
    }
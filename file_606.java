    private String formattedDate(Date d) {
        String formattedDate = "";
        if (d != null) {
            synchronized (SIMPLE_DATE_FORMAT) {
                formattedDate = SIMPLE_DATE_FORMAT.format(d);
            }
        }
        return formattedDate;
    }
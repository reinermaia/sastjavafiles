    public String getDateStringOrSuppliedString(String emptyDateString) {
        LocalDate date = getDate();
        return (date == null) ? emptyDateString : date.toString();
    }
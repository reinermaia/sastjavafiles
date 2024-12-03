    protected String toDateString(Object date) {
        String returnValue = null;
        if (date instanceof Date) {
        	SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
            Date d = (Date) date;
            returnValue = sdfDate.format(d);
        }
        return returnValue;
    }
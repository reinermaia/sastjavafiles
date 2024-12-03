    public static Date getCurrentDateTime() throws ParseException {
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_yyyyMMddTHHmmssSSSZ);
        String dateNow = formatter.format(currentDate.getTime());
        return getDateFromString(dateNow);
    }
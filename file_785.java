    public static Date getDateWithPrevDays(int noOfDays) throws ParseException {
        Calendar currentDate = Calendar.getInstance();
        currentDate.add(Calendar.DATE, -noOfDays);
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_yyyyMMddTHHmmssSSSZ);
        String dateNow = formatter.format(currentDate.getTime());
        return getDateFromString(dateNow);
    }
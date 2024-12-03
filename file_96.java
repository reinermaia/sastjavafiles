    public static String dateToString(Date d) {
        return d == null ? null : new SimpleDateFormat(DATE_FORMAT).format(d);  // TODO: use an Instant
    }
    private static String dateToString(Date date) {
        return date == null ? "" : new SimpleDateFormat(StageConverter.DATE_PATTERN).format(date);
    }
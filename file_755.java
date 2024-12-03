    private Date toDate(final String pStringDate) {

        // weird manipulation to parse the date... remove ':' from the timezone
        // before: 2011-07-12T22:42:40.000+02:00
        // after: 2011-07-12T22:42:40.000+0200
        final StringBuilder _date = new StringBuilder();
        _date.append(pStringDate.substring(0, pStringDate.length() - 3));
        _date.append(pStringDate.substring(pStringDate.length() - 2));
        try {
            return new SimpleDateFormat(RFC_339_DATE_FORMAT).parse(_date.toString());
        } catch (final ParseException e) {
            throw new IllegalArgumentException(
                    "The given spreadsheet ListEntry usercrashdate field value is malformed", e);
        }
    }
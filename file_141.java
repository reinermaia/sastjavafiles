    private static final BaseCalendar getCalendarSystem(long utc) {
        // Quickly check if the time stamp given by `utc' is the Epoch
        // or later. If it's before 1970, we convert the cutover to
        // local time to compare.
        if (utc >= 0
            || utc >= GregorianCalendar.DEFAULT_GREGORIAN_CUTOVER
                        - TimeZone.getDefaultRef().getOffset(utc)) {
            return gcal;
        }
        return getJulianCalendar();
    }
    public static String stringToString(String dateString, String desfmt) {
        // ISO_DATE_FORMAT = "yyyyMMdd";
        if (dateString.trim().length() == 8) {
            return stringToString(dateString, ISO_DATE_FORMAT, desfmt);
        } else if (dateString.trim().length() == 10) {
            // ISO_EXPANDED_DATE_FORMAT = "yyyy-MM-dd";
            return stringToString(dateString, ISO_EXPANDED_DATE_FORMAT, desfmt);
        } else if (dateString.trim().length() == 19) {
            // DATETIME_PATTERN = "yyyy-MM-dd hh:mm:ss";
            return stringToString(dateString.substring(0, 10),
                    ISO_EXPANDED_DATE_FORMAT, desfmt);
        } else if (dateString.trim().length() == 11) {
            // CHINESE_EXPANDED_DATE_FORMAT = "yyyy年MM月dd日";
            return stringToString(dateString, CHINESE_EXPANDED_DATE_FORMAT,
                    desfmt);
        }
        return null;
    }
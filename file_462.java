    private static String convertNumber(String signature, Number number) {
        long val = number.longValue();
        switch (signature) {
        case "Z":
            if (val == 0) {
                return "false";
            }
            return "true";
        case "C":
            if (val == '\n') {
                return "'\\n'";
            }
            if (val == '\r') {
                return "'\\r'";
            }
            if (val == '\b') {
                return "'\\b'";
            }
            if (val == '\t') {
                return "'\\t'";
            }
            if (val == '\'') {
                return "'\\''";
            }
            if (val == '\\') {
                return "'\\\\'";
            }
            if (val >= 32 && val < 128) {
                return "'" + ((char) val) + "'";
            }
            return convertNumber(val);
        case "I":
            if(val >= 32 && val < 128) {
                return val+" ('" + ((char) val) + "')";
            }
            return convertNumber(val);
        default:
            return convertNumber(val);
        }
    }
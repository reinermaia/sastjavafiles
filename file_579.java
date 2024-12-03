    public static String getHttpStatusCodeText(int sc) {
        HttpStatusCode sCode = HttpStatusCode.fromNumStatusCode(sc);
        if (sCode == null) {
            return sc + " <unknown status code>";
        } else {
            return sCode.toString();
        }
    }
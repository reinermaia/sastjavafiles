    private static Cookie createCookie(String name, String value, String domain, String path, Date expirationDate) {
        return createCookie(name, value, domain, path, expirationDate.getTime());
    }
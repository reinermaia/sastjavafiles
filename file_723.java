    public void createCookie(String name, String value, String domain, String path) {
        BasicClientCookie cookie = new BasicClientCookie(name, value);
        cookie.setDomain(domain);
        if (path != null) {
            cookie.setPath(path);
        }
        httpClient.getCookieStore().addCookie(cookie);
    }
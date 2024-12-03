    public static String encodeUrl(String url) {
        try {
            return URLEncoder.encode(url, DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException ignore) {
            return url;
        }
    }
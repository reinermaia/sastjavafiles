    private String urlEncode(String s) throws UnsupportedEncodingException {
        return URLEncoder.encode(s, String.valueOf(StandardCharsets.UTF_8));
    }
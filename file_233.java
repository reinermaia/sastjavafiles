    private String encode(String value) {
        try {
            //return URLEncoder.encode(value,"UTF-8");
            return UriUtils.encodeQueryParam(value, "UTF-8");
        } catch (UnsupportedEncodingException x) {
            throw new IllegalArgumentException(x);
        }
    }
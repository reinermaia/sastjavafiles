    private Object parseURL(URL url, Map params, String charset) {
            return parse(new StringReader( HTTP.getJSONWithParams ( url.toString (), null, params )));
    }
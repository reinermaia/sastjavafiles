    private void parseQuery(String query) {
        // throw out the funky business - "?"[name"="value"&"]+
        query = query.replaceAll("/&+/g", "&").replaceAll("/^\\?*&*|&+$/g", "");

        if (query.isEmpty())
            return;

        queryParams = GWT.create(Buckets.class);
        String[] p, pairs = query.split("&");
        String name, value;
        for (final String pair : pairs) {
            p = pair.split("=");
            name = urlCodec.decodeQueryString(p[0]);
            // no "=" is null according to http://dvcs.w3.org/hg/url/raw-file/tip/Overview.html#collect-url-parameters
            value = p.length > 1 && !p[1].isEmpty() ? urlCodec.decodeQueryString(p[1]) : null;
            queryParams.add(name, value);
        }
    }
    public static String stripProtocolAndPort(String url) {
        //workaround to properly parse url. Without schema and available port, URI.create fails to parse
        if (!url.contains("://")) {
            url = "http://" + url;
        }

        URI uri = URI.create(url);

        String host = uri.getHost();
        String path = uri.getPath();

        String query = uri.getQuery();
        String queryAppend = "";
        if (query != null) {
            queryAppend = "?" + query;
        }

        String fragment = uri.getFragment();
        String fragmentAppend = "";
        if (fragment != null) {
            fragmentAppend = "#" + fragment;
        }

        return (host == null ? "" : host) + (path == null ? "" : path) + queryAppend + fragmentAppend;
    }
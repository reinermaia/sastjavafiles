    public static String stripProtocol(String url) {
        //workaround to properly parse url. Without schema and available port, URI.create fails to parse
        if (!url.contains("://")) {
            url = "http://" + url;
        }

        URI uri = URI.create(url);

        String userInfo = uri.getUserInfo();

        String host = uri.getHost();
        int port = uri.getPort();
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

        return (userInfo == null ? "" : userInfo + "@") + (host == null ? "" : host) + (port == -1 ? "" : ":" + port) + (path == null ? "" : path) + queryAppend + fragmentAppend;
    }
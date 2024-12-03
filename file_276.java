    private String appendQueryString(String url, Map<String, Object> query) {
        if(query != null && query.size() > 0) {
            String queryString = this.queryAsString(query);
            return String.format("%s?%s", url, queryString);
        } else {
            return url;
        }
    }
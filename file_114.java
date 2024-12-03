    public CloseableHttpResponse postJson(String url, String json, Map<String, String> reqHeaders) throws IOException {
        CloseableHttpClient req = getClient();
        CloseableHttpResponse resp = null;
        HttpPost post = new HttpPost(url);
        addHeaders(post, reqHeaders);
        post.setHeader(json, url);
        StringEntity input = new StringEntity(json, ContentType.APPLICATION_JSON);
        post.setEntity(input);
        resp = req.execute(post);
        return resp;
    }
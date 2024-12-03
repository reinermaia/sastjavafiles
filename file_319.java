    private boolean httpPost(String url, String msg) {
        boolean ret = false;

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        try {
            HttpPost request = new HttpPost(url);
            List<NameValuePair> nvps = new ArrayList<>();
            nvps.add(new BasicNameValuePair("name", monitorName));
            nvps.add(new BasicNameValuePair("msg", msg));
            request.setEntity(new UrlEncodedFormEntity(nvps));
            response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                LOG.info(EntityUtils.toString(entity));
            }
            EntityUtils.consume(entity);
            ret = true;
        } catch (Exception e) {
            LOG.error("Exception when sending http request to ali monitor", e);
        } finally {
            try {
                if (response != null)
                    response.close();
                httpClient.close();
            } catch (Exception e) {
                LOG.error("Exception when closing httpclient", e);
            }
        }

        return ret;
    }
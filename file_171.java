  public void post(String jsonBody, Integer expectedResponseCode) throws IOException {
    HttpURLConnection conn = getUrlConnection();

    try {
      // send post request with json body for the topology
      if (!NetworkUtils.sendHttpPostRequest(conn, NetworkUtils.JSON_TYPE, jsonBody.getBytes())) {
        throw new IOException("Failed to send POST to " + endpointURI);
      }

      // check the response
      if (!NetworkUtils.checkHttpResponseCode(conn, expectedResponseCode)) {
        byte[] bytes = NetworkUtils.readHttpResponse(conn);
        LOG.log(Level.SEVERE, "Failed to send POST request to endpoint");
        LOG.log(Level.SEVERE, new String(bytes));
        throw new IOException("Unexpected response from connection. Expected "
            + expectedResponseCode + " but received " + conn.getResponseCode());
      }
    } finally {
      conn.disconnect();
    }
  }
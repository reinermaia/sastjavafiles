  public Observable<HttpClientResponse<ByteBuf>>
  postSmile(String uriStr, JsonPayload payload) {
    byte[] entity = toByteArray(SMILE_FACTORY, payload);
    URI uri = URI.create(uriStr);
    return rxHttp.post(uri, SMILE_CONTENT_TYPE, entity);
  }
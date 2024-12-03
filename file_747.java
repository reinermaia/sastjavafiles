  public static HttpRequest head(final CharSequence baseUrl,
      final Map<?, ?> params, final boolean encode) {
    String url = append(baseUrl, params);
    return head(encode ? encode(url) : url);
  }
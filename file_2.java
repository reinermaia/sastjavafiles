  private Cookie createCookie(String str) throws UnsupportedEncodingException {
    if (LOG.isDebugEnabled()) {
      LOG.debug("Cookie name = " + AUTH_COOKIE + " value = " + str);
    }
    Cookie cookie = new Cookie(AUTH_COOKIE, str);

    cookie.setMaxAge(cookieMaxAge);
    if (cookieDomain != null) {
      cookie.setDomain(cookieDomain);
    }
    if (cookiePath != null) {
      cookie.setPath(cookiePath);
    }
    cookie.setSecure(isCookieSecure);
    return cookie;
  }
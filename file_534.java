    private void dealWithCookie(boolean create) {
        if (!requestConfig.isDisableCookie()) {
            String cookieHeader = header.get("Cookie");
            if (cookieHeader != null) {
                cookies = Cookie.saxToCookie(cookieHeader);
                String jsessionid = Cookie.getJSessionId(cookieHeader);
                if (jsessionid != null) {
                    session = SessionUtil.getSessionById(jsessionid);
                }
            }
            if (create && session == null) {
                if (cookies == null) {
                    cookies = new Cookie[1];
                } else {
                    cookies = new Cookie[cookies.length + 1];
                }
                Cookie cookie = new Cookie(true);
                String jsessionid = UUID.randomUUID().toString();
                cookie.setName(Cookie.JSESSIONID);
                cookie.setPath("/");
                cookie.setValue(jsessionid);
                cookies[cookies.length - 1] = cookie;
                session = new HttpSession(jsessionid);
                SessionUtil.sessionMap.put(jsessionid, session);
                LOGGER.info("create a cookie " + cookie.toString());
            }
        }
    }
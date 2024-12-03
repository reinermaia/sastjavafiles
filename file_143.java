    private static int createCookie(final String name, final String value, int maxCookies, int cookieCount,
            final Map<String, String> cookies, final Map<String, String> additional) {
        if (!name.isEmpty() && name.charAt(0) == '$') {
            if(additional.containsKey(name)) {
                return cookieCount;
            }
            additional.put(name, value);
            return cookieCount;
        } else {
            if (cookieCount == maxCookies) {
                throw UndertowMessages.MESSAGES.tooManyCookies(maxCookies);
            }
            if(cookies.containsKey(name)) {
                return cookieCount;
            }
            cookies.put(name, value);
            return ++cookieCount;
        }
    }
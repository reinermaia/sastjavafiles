	public static String urlEncode(String str) {
		try {
			return URLEncoder.encode(str, UTF8);
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("failed to encode", e);
		}
	}
	private static String urlEncodePair(String k, String v) throws UnsupportedEncodingException {
		return String.format("%s=%s", URLEncoder.encode(k, CHARSET), URLEncoder.encode(v, CHARSET));
	}
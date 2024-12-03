    private static String encode(String str) {
	try {
	    return URLEncodedFormat.invoke(str, "UTF-8", false);
	}
	catch (PageException e) {
	    return URLEncoder.encode(str);
	}
    }
	protected String parseUrl(String url, List<Param> paramList) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		for (Param param : paramList) {
			if (param.getValue() == null) {
				continue;
			}
			if (sb.length() > 0) {
				sb.append('&');
			}

			sb.append(param.getName()).append('=').append(URLEncoder.encode(param.getValue().toString(), "UTF-8"));
		}
		String queryString = sb.toString();
		// System.err.println("queryString:" + queryString);
		if (url.indexOf("?") == -1) {
			return url + "?" + queryString;
		}
		else {
			return url + "&" + queryString;
		}
	}
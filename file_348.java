	private void patternCSSExtract(HTMLMetaData data, Pattern pattern, String content) {
		Matcher m = pattern.matcher(content);
		int idx = 0;
		int contentLen = content.length();
		if (contentLen > 100000)
			// extract URLs only from the first 100 kB
			contentLen = 100000;
		while((idx < contentLen) && m.find()) {
			idx = m.end();
			String url = m.group(1);
			url = cssUrlTrimPattern.matcher(url).replaceAll("");
			if (!url.isEmpty()) {
				data.addHref("path","STYLE/#text","href", url);
			}
		}
	}
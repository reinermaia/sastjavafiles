	private String getHtml()
	{
		String html = content;
		
		if (!html.matches("(?is).*<base\\s.*"))
		{
			String baseHref = url.toString().replaceAll("/[^/]*\\?.*", "/");
			html = html.replaceAll("(?is)(<head(?=\\s|>)[^>]*>)", "$1<base href=\"" + baseHref + "\"/>");
		}
		
		return html;
	}
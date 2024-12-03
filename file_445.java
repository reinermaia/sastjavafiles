	public WebPage getWebPage(Class<? extends WebPage> clazz, WebSiteRequest req) throws IOException {
		return getWebPage(getServletContext(), clazz, req);
	}
    public static String call(PageContext pc, String html) {
	return "<pre>" + HTMLEntities.escapeHTML(html, HTMLEntities.HTMLV40) + "</pre>";
    }
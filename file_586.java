	public String formatDate(String format, Locale loc) {
		MultivaluedMap<String, String> params = new MultivaluedHashMap<>();
		params.putSingle("format", format);
		params.putSingle("locale", loc == null ? null : loc.toString());
		return getEntity(invokeGet("utils/formatdate", params), String.class);
	}
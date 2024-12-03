	public String toHTML(Object content, Object extra) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		str(content, extra, out);
		return out.toString();
	}
	static String replaceSlashes(final String target) {
		String replaced = target;
		if (replaced != null) {
			replaced = replaced.replaceAll("/+", "/");
		}
		return replaced;
	}
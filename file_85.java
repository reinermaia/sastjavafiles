	static Integer toInt(String s) {
		if (s.isEmpty()) return null;
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			logger.warn(s + " is not an integer", e);
		}
		return null;
	}
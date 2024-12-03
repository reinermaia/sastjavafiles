	private static String coerceToEpoch(String s) {
		Long epoch = parseEpochSecond(s);
		if (epoch != null) {
			return String.valueOf(epoch);
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		try {
			return String.valueOf(format.parse(s).getTime());
		}
		catch (ParseException ex) {
			return s;
		}
	}
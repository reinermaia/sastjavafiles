	private static Date toDate(String dateString) {
		try {
			return new SimpleDateFormat(LOCAL_TREND_DATE_FORMAT).parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}
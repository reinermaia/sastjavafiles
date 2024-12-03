	public static Date getDay(String string) {
		if (string == null) {
			return null;
		}
		Date date = null;
		try {
			date = (new SimpleDateFormat("dd-MMM-yyyy").parse(string));
		}
		catch (ParseException ex) {
			return null;
		}
		return date;
	}
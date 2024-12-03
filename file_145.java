	public static String format(Date date, String format)
	{
		Parameters.checkNotNull(date);
		return new SimpleDateFormat(format).format(date);
	}
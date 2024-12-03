	public static String getRFC3881Timestamp(Date date)
	{
		
		StringBuilder formattedDate = new StringBuilder(RFC3881_DATE_FORMATTER.format(date));
		formattedDate.insert((formattedDate.length()-2), ':');
		return formattedDate.toString();
	}
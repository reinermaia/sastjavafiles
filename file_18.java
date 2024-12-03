	public static Date dateStringToDate(String dateString){
		SimpleDateFormat sdf=new SimpleDateFormat(DateTimeKit.FULL_DATE_24HR_STYLE);
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {}  
		return date;
	}
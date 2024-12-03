	private Date getDateBySupportedDateFormat(String dateStr) {
		
		for(String format : supportedDateFormat) {
			try {
				Date date = TimeUtil.getDateFormatter(format).parse(dateStr);
				return date;
			}catch (Exception e) {
				
			}
		}
		return null;
	}
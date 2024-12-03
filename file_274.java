	public static DateTime epoch() {
		 MutableDateTime epoch = new MutableDateTime();
		 
	     epoch.setDate(0); 
	     epoch.setTime(0);
	        
	     return epoch.toDateTime();
	}
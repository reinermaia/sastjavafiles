	public static String reverse(String string) {
		if(string != null) {
			return new StringBuilder(string).reverse().toString();
		}
		return null;
	}
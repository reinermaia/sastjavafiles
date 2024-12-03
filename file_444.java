	public static String readInputTextLine() {
		BufferedReader lineOfText = new BufferedReader(new InputStreamReader(
				System.in));
		String textLine = null;
		try {
			textLine = lineOfText.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return textLine;
	}
	public static String replace(final String string, final String find, final String replacement) {
		int pos = string.indexOf(find);
		//System.out.println(string+": "+find+" at "+pos);
		if (pos == -1) return string;
		StringBuilder SB = new StringBuilder();
		int lastpos = 0;
		final int findLen = find.length();
		do {
			SB.append(string, lastpos, pos).append(replacement);
			lastpos = pos + findLen;
			pos = string.indexOf(find, lastpos);
		} while (pos != -1);
		int len = string.length();
		if(lastpos<len) SB.append(string, lastpos, len);
		return SB.toString();
	}
	public static String[] split(final String src, final String delimiter) {
		int maxparts = (src.length() / delimiter.length()) + 2;		// one more for the last
		int[] positions = new int[maxparts];
		int dellen = delimiter.length();

		int i, j = 0;
		int count = 0;
		positions[0] = - dellen;
		while ((i = src.indexOf(delimiter, j)) != -1) {
			count++;
			positions[count] = i;
			j = i + dellen;
		}
		count++;
		positions[count] = src.length();

		String[] result = new String[count];

		for (i = 0; i < count; i++) {
			result[i] = src.substring(positions[i] + dellen, positions[i + 1]);
		}
		return result;
	}
	public static String toDecimalString(String inBinaryIpAddress) {
		StringBuilder decimalip = new StringBuilder();
		String[] binary = new String[4];
		
		for (int i = 0, c = 0; i < 32; i = i + 8, c++) {
			binary[c] = inBinaryIpAddress.substring(i, i + 8);
			int octet = Integer.parseInt(binary[c], 2);
			decimalip.append(octet);
			if (c < 3) {
				
				decimalip.append('.');
			}
		}
		return decimalip.toString();
	}
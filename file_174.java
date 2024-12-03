	public static long convertLongArrayFromHex(char[] hex) {
		int hexLen = hex.length;
		if(hexLen < 16) throw new IllegalArgumentException("Too few characters: " + hexLen);
		int h = (getHex(hex[0]) << 28)
			| (getHex(hex[1]) << 24)
			| (getHex(hex[2]) << 20)
			| (getHex(hex[3]) << 16)
			| (getHex(hex[4]) << 12)
			| (getHex(hex[5]) << 8)
			| (getHex(hex[6]) << 4)
			| (getHex(hex[7]))
		;
		int l = (getHex(hex[8]) << 28)
			| (getHex(hex[9]) << 24)
			| (getHex(hex[10]) << 20)
			| (getHex(hex[11]) << 16)
			| (getHex(hex[12]) << 12)
			| (getHex(hex[13]) << 8)
			| (getHex(hex[14]) << 4)
			| (getHex(hex[15]))
		;
		return (((long)h) << 32) | (l & 0xffffffffL);
	}
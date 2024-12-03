	private Decimal toDecimalSlow(int precision, int scale) {
		// As data in Decimal is currently stored by BigDecimal if `precision` > Decimal.MAX_LONG_DIGITS,
		// and BigDecimal only supports String or char[] for its constructor,
		// we can't directly extract the value from BinaryString.
		//
		// As BigDecimal(char[], int, int) is faster than BigDecimal(String, int, int),
		// we extract char[] from the memory segment and pass it to the constructor of BigDecimal.
		char[] chars = SegmentsUtil.allocateReuseChars(sizeInBytes);
		int len;
		if (segments.length == 1) {
			len = StringUtf8Utils.decodeUTF8Strict(segments[0], offset, sizeInBytes, chars);
		} else {
			byte[] bytes = SegmentsUtil.allocateReuseBytes(sizeInBytes);
			ensureMaterialized();
			SegmentsUtil.copyToBytes(segments, offset, bytes, 0, sizeInBytes);
			len = StringUtf8Utils.decodeUTF8Strict(bytes, 0, sizeInBytes, chars);
		}

		if (len < 0) {
			return null;
		} else {
			// Trim white spaces
			int start = 0, end = len;
			for (int i = 0; i < len; i++) {
				if (chars[i] != ' ' && chars[i] != '\n' && chars[i] != '\t') {
					start = i;
					break;
				}
			}
			for (int i = len - 1; i >= 0; i--) {
				if (chars[i] != ' ' && chars[i] != '\n' && chars[i] != '\t') {
					end = i + 1;
					break;
				}
			}
			try {
				BigDecimal bd = new BigDecimal(chars, start, end - start);
				return Decimal.fromBigDecimal(bd, precision, scale);
			} catch (NumberFormatException nfe) {
				return null;
			}
		}
	}
	public boolean testEncryption() {
		// Uses test data in rfc3711 to test encryption
		boolean ret = true;
		rollOverCounter = 0L;
		byte[] sessKey = { (byte) 0x2B, (byte) 0x7E, (byte) 0x15, (byte) 0x16,
				(byte) 0x28, (byte) 0xAE, (byte) 0xD2, (byte) 0xA6,
				(byte) 0xAB, (byte) 0xF7, (byte) 0x15, (byte) 0x88,
				(byte) 0x09, (byte) 0xCF, (byte) 0x4F, (byte) 0x3C };
		byte[] sessSalt = { (byte) 0xF0, (byte) 0xF1, (byte) 0xF2, (byte) 0xF3,
				(byte) 0xF4, (byte) 0xF5, (byte) 0xF6, (byte) 0xF7,
				(byte) 0xF8, (byte) 0xF9, (byte) 0xFA, (byte) 0xFB,
				(byte) 0xFC, (byte) 0xFD };

		byte[] IV = new byte[16];
		initialiseIV(IV, 0L, 0, 0L, sessSalt);
		byte[] outArray = null;
		try {
			// AESKey key = new AESKey(sessKey);
			// AESEncryptorEngine engine = new AESEncryptorEngine(key);
			EncryptorSuite encSuite = platform.getCrypto()
					.createEncryptorSuite(sessKey, initVector);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			for (int i = 0; i < 3; ++i) {
				//logBuffer("testEncryption, IV - ", IV);
				byte[] encrypted = encSuite.encryptIV_for_prf(IV);
				//logBuffer("testEncryption, encrypted block - ", encrypted);
				baos.write(encrypted);
				incrementIV(IV);
			}
			outArray = baos.toByteArray();
			baos.close();
			//logBuffer("testEncryption, outArray - ", outArray);
		} catch (Throwable e) {
			log("testEncryption, Exception thrown");
			ret = false;
		}
		String outString = platform.getUtils().byteToHexString(outArray);
		String expectedOutput = "E03EAD0935C95E80E166B16DD92B4EB4D23513162B02D0F72A43A2FE4A5F97AB41E95B3BB0A2E8DD477901E4FCA894C0";
		if (!outString.equalsIgnoreCase(expectedOutput)) {
			ret = false;
		}
		return ret;
	}
	public void doAESDecryption(byte[] salt, byte[] iv) throws Exception{
		setSalt(salt);
		if(!initAESDone)
			initAES();
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
		secretPlain = cipher.doFinal(secretCipher);
	}
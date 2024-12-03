	private byte[] aesDecrypt(byte[] encryptionKey, byte[] iv, byte[] encryptedMessage)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

		Cipher cipher = Cipher.getInstance(AES_CFB_NO_PADDING_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(encryptionKey, SYMMETRIC_KEY_TYPE), new IvParameterSpec(iv));
		return cipher.doFinal(encryptedMessage);

	}
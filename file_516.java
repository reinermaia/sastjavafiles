	public void doAESEncryption() throws Exception{
		if(!initAESDone)
			initAES();
		cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		//System.out.println(secretKey.getEncoded());
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		AlgorithmParameters params = cipher.getParameters();
		iv = params.getParameterSpec(IvParameterSpec.class).getIV();
		secretCipher = cipher.doFinal(secretPlain);
		clearPlain();
	}
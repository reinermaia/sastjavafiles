    private byte[] aesEncrypt(byte[] encryptionKey, byte[] iv, byte[] message)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher = Cipher.getInstance(AES_CFB_NO_PADDING_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptionKey, SYMMETRIC_KEY_TYPE), new IvParameterSpec(iv));
        return cipher.doFinal(message);
    }
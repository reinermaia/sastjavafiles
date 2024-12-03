    public static byte[] decryptAES(SecretKey key, byte[] iv, byte[] encryptedBytes) throws
            NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivParameter = new IvParameterSpec(iv);
        // see http://stackoverflow.com/a/11506343
        Key encryptionKey = new SecretKeySpec(key.getEncoded(),"AES");
        aesCipher.init(Cipher.DECRYPT_MODE, encryptionKey, ivParameter);
        return aesCipher.doFinal(encryptedBytes);
    }
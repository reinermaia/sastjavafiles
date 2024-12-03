    private byte[] doEncryptionOrDecryption(byte[] crypt, Key key, int mode) {
        Cipher rsaCipher;
        try {
            rsaCipher = Cipher.getInstance(CIPHER);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw SeedException.wrap(e, CryptoErrorCode.UNABLE_TO_GET_CIPHER)
                    .put("alias", alias)
                    .put("cipher", CIPHER);
        }
        try {
            rsaCipher.init(mode, key);
        } catch (InvalidKeyException e) {
            throw SeedException.wrap(e, CryptoErrorCode.INVALID_KEY)
                    .put("alias", alias);
        }
        try {
            return rsaCipher.doFinal(crypt);
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            throw SeedException.wrap(e, CryptoErrorCode.UNEXPECTED_EXCEPTION);
        }
    }
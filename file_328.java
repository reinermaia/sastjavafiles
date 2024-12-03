    @Override
    public String encrypt(String plainText) throws CryptoException {
        try {
            byte[] initializationVector = getIvProviderInstance().createIV();
            Cipher encryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            encryptCipher.init(Cipher.ENCRYPT_MODE, createSecretKeySpec(), new IvParameterSpec(initializationVector));

            byte[] bytesToEncrypt = plainText.getBytes(StandardCharsets.UTF_8);
            byte[] encryptedBytes = encryptCipher.doFinal(bytesToEncrypt);

            return String.join(":", "AES", ENCODER.encodeToString(initializationVector), ENCODER.encodeToString(encryptedBytes));
        } catch (Exception e) {
            throw new CryptoException(e);
        }
    }
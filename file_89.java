    private byte[] encrypt(byte[] secretKey, String data) throws InvalidKeyException {
        byte[] encryptedData = null;
        try {
            // Encrypt data using the secret key
            Cipher aescf = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivspec = new IvParameterSpec(new byte[16]);
            aescf.init(Cipher.ENCRYPT_MODE,
                    new SecretKeySpec(secretKey, "AES"), ivspec);
            encryptedData = aescf.doFinal(data.getBytes(UTF8));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Exception encrypting data", e);
        }
        return encryptedData;
    }
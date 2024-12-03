  byte[] encryptData(byte[] plaintext, PasswordKey encryptionKey, PasswordKey hmacKey, byte[] iv) throws CryptorException {
    try {
      Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
      cipher.init(Cipher.ENCRYPT_MODE, encryptionKey.getKey(), new IvParameterSpec(iv));
      byte[] ciphertext = cipher.doFinal(plaintext);

      AES256v3Ciphertext output = new AES256v3Ciphertext(encryptionKey.getSalt(),
          hmacKey.getSalt(), iv, ciphertext);

      Mac mac = Mac.getInstance(HMAC_ALGORITHM);
      mac.init(hmacKey.getKey());
      byte[] hmac = mac.doFinal(output.getDataToHMAC());
      output.setHmac(hmac);
      return output.getRawData();

    } catch (InvalidKeyException e) {
      throw new CryptorException(
          "Caught InvalidKeyException. Do you have unlimited strength jurisdiction files installed?",
          e);
    } catch (GeneralSecurityException e) {
      throw new CryptorException("Failed to generate ciphertext.", e);
    }    
  }
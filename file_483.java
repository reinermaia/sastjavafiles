  private static String encodeAsHex(byte[] input) {
    StringBuilder hexString = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      String hex = Integer.toHexString(0xff & input[i]);
      if (hex.length() == 1) {
        hexString.append('0');
      }
      hexString.append(hex);
    }
    return hexString.toString();
  }
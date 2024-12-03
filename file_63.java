    public static byte[] fromHex(String hex) {
        try {
            return Hex.decodeHex(hex.toCharArray());
        } catch (DecoderException e) {
            return null;
        }
    }
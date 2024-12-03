    private static int decode(final int hex) {
        if (hex >= CcHex.BACK.length) {
            throw new DecodingException(
                String.format("invalid hex char: 0x%2x", hex)
            );
        }
        final int dec = CcHex.BACK[hex];
        if (dec < 0) {
            throw new DecodingException(
                String.format("invalid hex character: 0x%2x", hex)
            );
        }
        return dec;
    }
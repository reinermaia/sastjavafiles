    public static BigInteger unscaledDecimalToBigInteger(Slice decimal)
    {
        byte[] bytes = decimal.getBytes(0, UNSCALED_DECIMAL_128_SLICE_LENGTH);
        // convert to big-endian order
        reverse(bytes);
        bytes[0] &= ~SIGN_BYTE_MASK;
        return new BigInteger(isNegative(decimal) ? -1 : 1, bytes);
    }
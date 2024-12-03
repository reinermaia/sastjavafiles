    @Override
    public void sendBinary(@Sensitive ByteBuffer partialByte, boolean isLast) throws IOException {
        if (partialByte == null) {
            IllegalArgumentException up = new IllegalArgumentException();
            throw up;
        }

        impl.sendBinary(partialByte, OpcodeType.BINARY_WHOLE, isLast);
        return;

    }
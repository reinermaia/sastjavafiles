    public void sendBinary(@Sensitive ByteBuffer data, OpcodeType type, boolean isLast) throws IOException {

        OpcodeType t = type;

        if (messageWriteState == MessageWriteState.PARTIAL_TEXT_IN_USE) {
            if (tc.isDebugEnabled()) {
                Tr.debug(tc, "Send while Send outstanding error.  throw IllegalStateException");
            }
            // another send is outstanding on this connection, as per spec behaivor, need to throw an illegalStateException
            IllegalStateException up = new IllegalStateException();
            throw up;
        }

        if (messageWriteState == MessageWriteState.PARTIAL_NOT_IN_USE) {
            messageWriteState = MessageWriteState.PARTIAL_BINARY_IN_USE;
            if (isLast) {
                t = OpcodeType.BINARY_WHOLE;
            } else {
                t = OpcodeType.BINARY_PARTIAL_FIRST;
            }
        } else {
            if (isLast) {
                t = OpcodeType.BINARY_PARTIAL_LAST;
            } else {
                t = OpcodeType.BINARY_PARTIAL_CONTINUATION;
            }
        }

        try {
            RETURN_STATUS ret = sendBinaryCommon(data, t, false);
            if (ret != RETURN_STATUS.OK) {
                // another write of an IO frame is outstanding on this connection
                IllegalStateException up = new IllegalStateException("write not allowed.  Most likely cause is that another Write or Close is in progress");
                throw up;
            }
        } finally {
            if (isLast == true) {
                messageWriteState = MessageWriteState.PARTIAL_NOT_IN_USE;
            }
        }
    }
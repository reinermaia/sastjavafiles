    public void sendBinary(@Sensitive ByteBuffer data, OpcodeType type) throws IOException {

        if (messageWriteState != MessageWriteState.PARTIAL_NOT_IN_USE) {
            if (tc.isDebugEnabled()) {
                Tr.debug(tc, "Send while Send outstanding error.  throw IllegalStateException");
            }
            // another send is outstanding on this connection, as per spec behaivor, need to throw an illegalStateException
            IllegalStateException up = new IllegalStateException();
            throw up;
        }

        RETURN_STATUS ret = sendBinaryCommon(data, type, false);
        if (ret != RETURN_STATUS.OK) {
            // another write of an IO frame is outstanding on this connection
            IllegalStateException up = new IllegalStateException("write not allowed.  Most likely cause is that another Write or Close is in progress");
            throw up;
        }
    }
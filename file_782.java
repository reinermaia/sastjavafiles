    public CheckedSocket createSocket(long timeout)
        throws ConnectException, SocketException
    {
        Socket socket = SocketConnector.connect
            (mAddr, mPort, mLocalAddr, mLocalPort, timeout);
        if (socket == null) {
            throw new ConnectException("Connect timeout expired: " + timeout);
        }
        return CheckedSocket.check(socket);
    }
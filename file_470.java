    public CheckedSocket createSocket(long timeout)
        throws ConnectException, SocketException
    {
        Socket socket = SocketConnector.connect
            (mAddr, mPort, mLocalAddr, mLocalPort, timeout);
        if (socket == null) {
            throw new ConnectException("Connect timeout expired: " + timeout);
        }
        try {
            socket = mSSLFactory.createSocket
                (socket, mAddr.getHostAddress(), mPort, true);
        }
        catch (IOException e)  {
            throw new SocketException(e.toString());
        }
        return CheckedSocket.check(socket);
    }    
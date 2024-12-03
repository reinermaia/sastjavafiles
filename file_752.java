    private byte[] recv(Socket socket, int flags)
    {
        Utils.checkArgument(socket != null, "socket parameter must not be null");
        data = socket.recv(flags);
        more = socket.hasReceiveMore();
        return data;
    }
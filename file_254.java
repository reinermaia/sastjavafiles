    private static void setTimeout(Socket socket, long timeoutMs) {
        try {
            socket.setSoTimeout((int) timeoutMs);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }
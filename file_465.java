    private int pickAPort(int port) {
        if (port == 0) {
            port = 9000 + random.nextInt(10000);
            logger.debug("Random port lookup - Trying with {}", port);
        }
        return port;
    }
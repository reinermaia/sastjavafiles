    @Override
    public synchronized DBConnect getDBConnect() {
        DBConnect connect = threadConnect.get();
        if (connect == null) {
            connect = useConnect();
            threadConnect.set(connect);
        }
        return connect;
    }
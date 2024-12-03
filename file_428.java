    private JDBCConnect useConnect() {
        JDBCConnect connect = null;
        try {
            connect = connects.pop();
            if (connect != null) {
                if (connect.getEnd().getTime() <= new Date().getTime() || !connect.getConnect().isValid(1000)) {
                    connect.close();
                    connect = null;
                }
            }
        } catch (EmptyStackException | SQLException e) {
            connect = null;
            //try create connect
            createConnect();
        }
        return connect == null ? useConnect() : connect;
    }
    @Override
    public synchronized DBConnect getDBConnect() {
        try {
            DBConnect connect = threadConnect.get();
            if (connect == null) {
                connect = new DruidConnect(ds.getConnection());
                LOGGER.info("druid debug ------ create common connect : {}", connect);
                threadConnect.set(connect);
            } else {
                if (!connect.getConnect().isValid(3000) || connect.getConnect().isClosed()) {
                    connect = new DruidConnect(ds.getConnection());
                    LOGGER.info("druid debug ------ create common connect : {}", connect);
                    threadConnect.set(connect);
                }
            }
            return connect;
        } catch (SQLException e) {
            LOGGER.error(e, "get druid connect error");
            return null;
        }
    }
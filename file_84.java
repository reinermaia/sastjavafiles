    private Object excuteQuery(String sql, Object[] objects, DBConnect connect, DaoMethod daoMethod) throws SQLException {
        if (daoMethod.isList()) {
            if (daoMethod.isArray()) {
                return SilentGoOrm.queryArrayList(connect, sql, daoMethod.getType(), objects);
            } else {
                return SilentGoOrm.queryList(connect, sql, daoMethod.getType(), objects);
            }
        } else if (daoMethod.isArray()) {
            return SilentGoOrm.queryArray(connect, sql, daoMethod.getType(), objects);
        } else {
            return SilentGoOrm.query(connect, sql, daoMethod.getType(), objects);
        }
    }
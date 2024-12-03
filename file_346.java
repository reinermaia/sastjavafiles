    @NotNull
    private Connection ensureConnection() {
        if (sqlConnection == null) {
            try {
                sqlConnection = db.dataSource.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException("Failed to get connection from DataSource!", e);
            }
        }
        return sqlConnection;
    }
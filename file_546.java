  private Connection createDdlConnection() throws SQLException {
    Connection writeConnection = db.getDataSource().getConnection();
    writeConnection.setAutoCommit(false);
    return writeConnection;
  }
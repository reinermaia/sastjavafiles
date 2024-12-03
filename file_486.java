  @Override
  void handle(Connection connection, DatabaseCharsetChecker.State state) throws SQLException {
    // PostgreSQL does not have concept of case-sensitive collation. Only charset ("encoding" in postgresql terminology)
    // must be verified.
    expectUtf8AsDefault(connection);

    if (state == DatabaseCharsetChecker.State.UPGRADE || state == DatabaseCharsetChecker.State.STARTUP) {
      // no need to check columns on fresh installs... as they are not supposed to exist!
      expectUtf8Columns(connection);
    }
  }
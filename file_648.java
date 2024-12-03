	public String getDatabaseProductName() throws DatabaseException {
		Connection connection = null;
        Database database = null;
		String name = "unknown";
		try {
			connection = getDataSource().getConnection();
			database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
			name = database.getDatabaseProductName();
		} catch (SQLException e) {
			throw new DatabaseException(e);
		} finally {
            if (database != null) {
                database.close();
            } else if (connection != null) {
				try {
					if (!connection.getAutoCommit()) {
						connection.rollback();
					}
					connection.close();
                } catch (SQLException e) {
					log.warning(LogType.LOG, "problem closing connection", e);
				}
			}
		}
		return name;
	}
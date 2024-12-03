  public static String buildCreatePropertyTableSQL(DBNameResolver dbNameResolver) {
    StringBuilder sqlBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    sqlBuilder.append(dbNameResolver.getTableName(TableName.LOGGING_EVENT_PROPERTY)).append(" (")
        .append(dbNameResolver.getColumnName(ColumnName.EVENT_ID)).append(" BIGINT NOT NULL, ")
        .append(dbNameResolver.getColumnName(ColumnName.MAPPED_KEY)).append(" VARCHAR(254) NOT NULL, ")
        .append(dbNameResolver.getColumnName(ColumnName.MAPPED_VALUE)).append(" VARCHAR(254) NOT NULL, ")
        .append("PRIMARY KEY (")
        .append(dbNameResolver.getColumnName(ColumnName.EVENT_ID)).append(", ")
        .append(dbNameResolver.getColumnName(ColumnName.MAPPED_KEY)).append("), ")
        .append("FOREIGN KEY (")
        .append(dbNameResolver.getColumnName(ColumnName.EVENT_ID)).append(") ")
        .append("REFERENCES ")
        .append(dbNameResolver.getTableName(TableName.LOGGING_EVENT)).append(" (")
        .append(dbNameResolver.getColumnName(ColumnName.EVENT_ID)).append(") ")
        .append(")");
    return sqlBuilder.toString();
  }
	protected String getRealTableName(String schema, String tableName) throws DatabaseException{
		StringBuffer sql = new StringBuffer();

//		SQL sql1 = SELECT("c.relname")
//				.FROM("pg_catalog.pg_class").AS("c")
//				.FIELD("pg_class.relname")
//				.LEFT_JOIN("pg_catalog.pg_namespace").AS("n")
//				.ON("n.oid","c.relnamespace")
//				.WHERE(LOWER("c.relname")).EQUAL_TO(LOWER(tableName));

		sql.append("SELECT "+
				" c.relname as \"Table\""+
				" FROM"+
				" pg_catalog.pg_class c" +
				" LEFT JOIN pg_catalog.pg_namespace n ON n.oid = c.relnamespace"+
				" WHERE lower(c.relname) = lower(?)");
		if(schema != null){
			sql.append(" AND n.nspname = lower(?)");
		}
		sql.append(" ORDER BY c.relname");
		Object[] parameters = null;
		if(schema != null){
			parameters = new Object[2];
			parameters[0] = tableName;
			parameters[1] = schema;
		}else{
			parameters = new Object[1];
			parameters[0] = tableName;
		}

		try {
			ResultSet rs = executeSelectSQL(sql.toString(), parameters);
			if(rs != null){
				if(rs.next()){
					String realTableName = rs.getString(1);
					return realTableName;
				}
			}
		} catch (SQLException e) {
			//System.err.println(sql+"["+(parameters!=null?Arrays.asList(parameters):"")+"]");
			e.printStackTrace();
			throw new DatabaseException();
		}
		return null;

	}
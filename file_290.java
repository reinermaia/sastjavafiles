	public static ArrayList<String> getColumnNames(SQLiteDatabase db, String table) {
		return readStrings(db, "PRAGMA table_info(" + table + ")", 1);
	}
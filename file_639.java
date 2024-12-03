    public String getTableNames(boolean bAddQuotes)
    {
        if (m_tableName == null)
        {
            String strDatabaseName = "";
            if (this.getDatabaseName() != null)
                if (!this.getDatabaseName().endsWith("_" + this.getDatabaseName()))
                    strDatabaseName = "_" + this.getDatabaseName();
            return Record.formatTableNames(DATABASE_INFO_FILE, bAddQuotes) + strDatabaseName;
        }
        return super.getTableNames(bAddQuotes);
    }
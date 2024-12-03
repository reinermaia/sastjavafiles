    public String getTableNames(boolean bAddQuotes)
    {
        return (m_tableName == null) ? Record.formatTableNames(CLASS_FIELDS_FILE, bAddQuotes) : super.getTableNames(bAddQuotes);
    }
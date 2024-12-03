    public SQLBuilder except(final Collection<String> columnNames) {
        op = OperationType.QUERY;

        this.columnNames = null;
        this.columnNameList = columnNames;
        this.columnAliases = null;

        sb.append(_SPACE_EXCEPT_SPACE);

        return this;
    }
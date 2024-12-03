    public AbstractJdbcHelper init() {
        dataSources.forEach((key, ds) -> DbcHelper.registerJdbcDataSource(id + "-" + key, ds));
        return this;
    }
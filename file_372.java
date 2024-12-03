    @Override
    public void open(Properties configuration) throws TransformationException {
	try {
	    connection = PostgreSQLUtils.connect(configuration);
	} catch (SQLException e) {
	    throw new TransformationException("Could not open connection to PostgreSQL.", e);
	}
    }
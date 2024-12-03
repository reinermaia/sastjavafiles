    private @NotNull List<?> readArray(@NotNull Array array) {
        try {
            boolean allowNulls = !TypeUtils.isPrimitive(elementType);
            ResultSet resultSet = array.getResultSet();
            try {
                NamedTypeList types = NamedTypeList.builder(1).add("value", ResultSetUtils.getColumnType(resultSet.getMetaData(), 2)).build();
                Instantiator<?> ctor = instantiatorRegistry.findInstantiator(elementType, types);
                ArrayList<Object> result = new ArrayList<>();

                // For performance reasons we reuse the same arguments-array and InstantiatorArguments-object for all rows.
                // This should be fine as long as the instantiators don't hang on to their arguments for too long.
                Object[] arguments = new Object[1];
                InstantiatorArguments instantiatorArguments = new InstantiatorArguments(types, arguments);

                while (resultSet.next()) {
                    arguments[0] = resultSet.getObject(2);

                    Object value = ctor.instantiate(instantiatorArguments);
                    if (value != null || allowNulls)
                        result.add(value);
                    else
                        throw new UnexpectedResultException("Expected " + elementType + ", but got null");
                }

                return result;

            } finally {
                try {
                    resultSet.close();
                } finally {
                    SqlUtils.freeArray(array);
                }
            }

        } catch (SQLException e) {
            throw new DatabaseSQLException(e);
        }
    }
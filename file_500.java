    private ModelNode convertBoolean(Xml configuration) {
        String v = getValue.apply(configuration);
        Boolean boolVal = "true".equalsIgnoreCase(v)
                ? Boolean.TRUE
                : ("false".equalsIgnoreCase(v) ? Boolean.FALSE : null);
        if (boolVal == null) {
            throw new IllegalArgumentException("'true' or 'false' expected as a boolean value.");
        }
        return new ModelNode(boolVal);
    }
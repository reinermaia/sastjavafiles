    public static Properties readPropertiesFromFile(String _fileName, Properties _props) {
        Properties props = _props == null ? new Properties() : _props;

        LOGGER.debug("Trying to read properties from file: " + _fileName);
        Properties newProperties = readProperties(new File(_fileName));
        if (newProperties != null) {
            LOGGER.debug("Successfully read properties from file: " + _fileName);
            props.putAll(newProperties);
        }

        return props;
    }
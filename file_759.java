    public static void extractTextFromSingleProperty(Object propertyValue, TypeFactory<String> type,
                                                     BinaryStore binaries, StringBuilder fullTextString) {
        if (propertyValue instanceof Binary && binaries != null) {
            // Try extracting the text from the binary value ...
            try {
                propertyValue = binaries.getText((BinaryValue)propertyValue);
            } catch (BinaryStoreException e) {
                NodeSequence.LOGGER.debug("Error getting full text from binary {0}", propertyValue);
            }
        }
        if (propertyValue != null) {
            // Convert all other types to a string ...
            fullTextString.append(' ').append(type.create(propertyValue));
        }
    }
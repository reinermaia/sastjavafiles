    public static <T> T deserialize(byte[] input, Class<T> classType)
            throws JsonParseException, JsonMappingException, IOException {
        return mapper.readValue(input, classType);
    }
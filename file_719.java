    @Override
    public TypedObject deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException
    {
        try {
            JsonNode jsonNode = jp.readValueAsTree();
            return deserializeObject(jsonNode);
        }
        catch (Exception e) {
            throw new JsonMappingException("Invalid object class", e);
        }
    }
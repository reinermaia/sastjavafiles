    public T deserialize( JsonReader reader, JsonDeserializationContext ctx ) throws JsonDeserializationException {
        return deserialize( reader, ctx, JsonDeserializerParameters.DEFAULT );
    }
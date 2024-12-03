	public static Object deserialize(String json, TypeReference<?> typeReference) throws SerializationException {
		try {
			logger.debug("Json string to deserialize {} ", json);
			return mapper.readValue(json, typeReference);
		} catch (IOException e) {
			logger.error("SerializationException {}", e.getMessage());
			SerializationException serializationException = new SerializationException(e);
			throw serializationException;
		}
	}
	private String prettyPrint(final JsonObject json) {
		final Map<String, Object> properties = new HashMap<>(1);
		properties.put(JsonGenerator.PRETTY_PRINTING, true);
		final JsonWriterFactory writerFactory = Json.createWriterFactory(properties);

		final StringWriter sw = new StringWriter();
		try (final JsonWriter jsonWriter = writerFactory.createWriter(sw)) {
			jsonWriter.writeObject(json);

		}
		return sw.toString();
	}
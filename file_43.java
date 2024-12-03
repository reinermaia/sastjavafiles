	public Map<?, ?> formatJSON2Map(String json) {
		Map<?, ?> map = null;
		try {
			map = MAPPER.readValue(json, Map.class);
		} catch (Exception e) {
			LOGGER.error("formatJsonToMap error, json = " + json, e);
		}
		return map;
	}
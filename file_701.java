    @Override
    public JsonNode post(HttpEntity data, String path, Object... parameters) {
        return httpClient.post(
                this::toJson,
                data,
                path,
                parameters
        );
    }
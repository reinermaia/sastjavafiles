    private String convertToJson(Map<String, ?> map) throws MovieDbException {
        try {
            return MAPPER.writeValueAsString(map);
        } catch (JsonProcessingException ex) {
            throw new MovieDbException(ApiExceptionType.MAPPING_FAILED, "JSON conversion failed", "", ex);
        }
    }
    public static String toPrettyJsonString(Object object) {
        try {
            return jsonMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return JMExceptionManager.handleExceptionAndReturnNull(log, e,
                    "toPrettyJsonString", object);
        }
    }
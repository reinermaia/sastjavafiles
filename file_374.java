    public static String generate(InputStream inputStream) throws IOException {
        logger.trace("Converting XML document [{}]");
        // Extracting XML content
        // See #185: https://github.com/dadoonet/fscrawler/issues/185

        Map<String, Object> map = generateMap(inputStream);

        // Serialize to JSON
        String json = mapper.writeValueAsString(map);

        logger.trace("Generated JSON: {}", json);
        return json;
    }
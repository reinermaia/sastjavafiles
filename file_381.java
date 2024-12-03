    private String prettyPrintIfNeeded(Logger logger, String contentType, String body) {
        String result = body;
        if (prettyPrintJSON && contentType != null && (contentType.startsWith("application/json") || contentType.startsWith("text/json"))) {
            try {
                final Object deserialized = PRETTY_PRINTER.readTree(body);
                result = PRETTY_PRINTER.writeValueAsString(deserialized);
            } catch (Exception e) {
                log(logger, "Failed to pretty print JSON: " + e.getMessage());
            }
        }
        return result;
    }
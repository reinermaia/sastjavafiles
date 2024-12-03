    private String filterKnownEntities(String html) {
        return html.replace(ENTITY_QUOTE, SYMBOL_QUOTE)
                .replace(ENTITY_EQUAL_, SYMBOL_EQUAL)
                .replace(ENTITY_EQUAL, SYMBOL_EQUAL);
    }
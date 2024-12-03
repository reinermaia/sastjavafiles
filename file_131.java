    public static String htmlDecode(final String encodedHtml) {
        validate(encodedHtml, NULL_STRING_PREDICATE, NULL_STRING_MSG_SUPPLIER);
        String[] entities = encodedHtml.split("&\\W+;");
        return Arrays.stream(entities).map(e -> HtmlEntities.decodedEntities.get(e)).collect(joining());
    }
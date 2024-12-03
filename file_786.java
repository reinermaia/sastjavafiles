    private JsonObject convertXmlElementsToJsonObject(final List<Element> xmlElements, final boolean includeAttributes, final String textPropName) {
        JsonObject result = new JsonObject();
        for (final Element xmlElement : xmlElements) {
            result = addXmlElementToJsonObject(result, xmlElement, includeAttributes, textPropName);
        }
        return result;
    }
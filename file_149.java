    private String prettyPrint(final JsonObject rootJson, final boolean prettyPrint) {
        if (prettyPrint) {
            final Gson gson = new GsonBuilder().setPrettyPrinting()
                    .disableHtmlEscaping()
                    .create();
            return gson.toJson(rootJson);
        }
        return rootJson.toString();
    }
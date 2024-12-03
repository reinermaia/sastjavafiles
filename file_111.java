    public void setJsonMap(Map<String, Object> resultMap) {
        String json = gson.toJson(resultMap, Map.class);
        setJsonObject(new JsonParser().parse(json).getAsJsonObject());
    }
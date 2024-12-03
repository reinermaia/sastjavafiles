    public Map<String, Object> toJson() {
        Map<String, Object> jsonMap = new LinkedHashMap<>();
        jsonMap.put(key, value);
        return jsonMap;
    }
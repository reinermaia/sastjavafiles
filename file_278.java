    private static Json.JObject toObject(Map<String, Value> object) {
        Map<String, Json.JValue> map = new LinkedHashMap<>();
        object.forEach((k, v) -> map.put(k, v.asJson()));
        return Json.jObject(map);
    }
    private Map<String, Object> toMap(JSONObject o) {
        Map<String, Object> map = new LinkedHashMap<>();
        // https://github.com/jwtk/jjwt/issues/380: use .keys() and *not* .keySet() for Android compatibility:
        Iterator<String> iterator = o.keys();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Object value = o.get(key);
            value = convertIfNecessary(value);
            map.put(key, value);
        }
        return map;
    }
    @SuppressWarnings("unused")
    private String extractFirst(Map data, String field, String property) {
        List<Map> inner = (List<Map>) data.get(field);
        if (inner == null || inner.isEmpty()) {
            return null;
        }
        return (String) inner.get(0).get(property);
    }
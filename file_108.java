    public CaseInsensitiveRegexHashMap toCaseInsensitiveRegexMultiMap(List<T> entries) {
        CaseInsensitiveRegexHashMap caseInsensitiveRegexHashMap = new CaseInsensitiveRegexHashMap();
        if (entries != null) {
            for (KeyAndValue keyToMultiValue : entries) {
                caseInsensitiveRegexHashMap.put(keyToMultiValue.getName(), keyToMultiValue.getValue());
            }
        }
        return caseInsensitiveRegexHashMap;
    }
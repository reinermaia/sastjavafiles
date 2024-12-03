    @SuppressWarnings("unchecked")
    public static Map<String, Object> deserialize(byte[] json) {
        try {
            return getsMapper().readValue(json, Map.class);
        } catch (RuntimeException e){
            throw e;
        } catch (Exception e) {
            throw new IllegalStateException("Error converting byte[] to map object: " +
                    bytesToString(json));
        }
    }
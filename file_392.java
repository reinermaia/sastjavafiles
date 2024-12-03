    public static Double[] nullToEmpty(Double[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_DOUBLE_OBJECT_ARRAY;
        }
        return array;
    }
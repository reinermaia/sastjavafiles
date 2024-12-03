    public void initAsCopyOf(MArray array, boolean isMutable) {
        super.initAsCopyOf(array, isMutable);
        baseArray = array != null ? array.getBaseArray() : null;
        values = array != null ? new ArrayList<>(array.values) : new ArrayList<>();
    }
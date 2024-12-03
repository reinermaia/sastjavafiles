    @SuppressWarnings("unchecked")
    public <A> A[] toArray(A[] emptyArray) {
        if(emptyArray.length != 0) {
            throw new IllegalArgumentException("Empty array must be supplied");
        }
        return stream().toArray(size -> size == 0 ? emptyArray
                : (A[]) Array.newInstance(emptyArray.getClass().getComponentType(), size));
    }
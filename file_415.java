    @Override
    public Filter[] filterChainToArray() {
        int length = chainLength();
        Filter[] array = new Filter[length];
        Filter thisFilter = this;
        for (int i = 0; i < length; i++) {
            array[i] = thisFilter;
            thisFilter = thisFilter.getAnd();
        }
        return array;
    }
    public static Filter filterArrayToChain(Filter[] filterArray) {
        for (int i = 0; i < (filterArray.length - 1); i++) {
            AbstractFilter thisFilter = (AbstractFilter) filterArray[i];
            thisFilter.setAnd(filterArray[i + 1]);
        }
        AbstractFilter lastFilter = (AbstractFilter) filterArray[filterArray.length - 1];
        lastFilter.setAnd(null);
        return filterArray[0];
    }
    public static Filter or(Filter... filter) {
        if (filter.length == 1) return filter[0];
        OrFilter result = new OrFilter();
        for (int i = 0; i < filter.length; i++) {
            result.or(filter[i]);
        }
        return result;
    }
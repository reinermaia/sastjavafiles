    public static Filter and(Filter... filter) {
        if (filter.length == 1) return filter[0];
        AndFilter result = new AndFilter();
        for (int i = 0; i < filter.length; i++) {
            result.and(filter[i]);
        }
        return result;
    }
    private <T, R> Function<T, R> memoize(final Function<T, R> fn) {

        if (!autoMemoize)
            return fn;
        if (memoizeFactory == null)
            return Memoize.memoizeFunction(fn);
        return Memoize.memoizeFunction(fn, memoizeFactory);
    }
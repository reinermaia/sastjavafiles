    public Closure<V> memoizeAtMost(final int maxCacheSize) {
        if (maxCacheSize < 0) throw new IllegalArgumentException("A non-negative number is required as the maxCacheSize parameter for memoizeAtMost.");

        return Memoize.buildMemoizeFunction(new LRUCache(maxCacheSize), this);
    }
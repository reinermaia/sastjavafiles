    public Closure<V> memoizeAtLeast(final int protectedCacheSize) {
        if (protectedCacheSize < 0) throw new IllegalArgumentException("A non-negative number is required as the protectedCacheSize parameter for memoizeAtLeast.");

        return Memoize.buildSoftReferenceMemoizeFunction(protectedCacheSize, new ConcurrentSoftCache<Object, Object>(), this);
    }
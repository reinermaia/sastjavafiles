    @SuppressWarnings("unchecked")
    public final T[] filter(final T[] objects) {
        final Collection<T> filtered = filter(Arrays.asList(objects));
        try {
            return filtered.toArray((T[]) Array.newInstance(objects
                    .getClass(), filtered.size()));
        } catch (ArrayStoreException ase) {
            Logger log = LoggerFactory.getLogger(Filter.class);
            log.warn("Error converting to array - using default approach", ase);
        }
        return (T[]) filtered.toArray();
    }
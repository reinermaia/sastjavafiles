    @SafeVarargs
    public static <T> PriorityQueue<T> asPriorityQueue(final T... a) {
        if (N.isNullOrEmpty(a)) {
            return new PriorityQueue<>();
        }

        final PriorityQueue<T> queue = new PriorityQueue<>(a.length);

        for (T e : a) {
            queue.add(e);
        }

        return queue;
    }
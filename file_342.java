    public static <E> PriorityQueue<E> newPriorityQueue(final PriorityQueue<? extends E> c) {
        return new PriorityQueue<E>(c);
    }
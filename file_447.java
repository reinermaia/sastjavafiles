    public PriorityQueue<Pair<T, Double>> asPriorityQueue() {
        PriorityQueue<Pair<T, Double>> pq = new PriorityQueue<>(Math.max(1,map.size()), new PairComparator());
        for (Map.Entry<T, AtomicDouble> entry : map.entrySet()) {
            pq.add(Pair.create(entry.getKey(), entry.getValue().get()));
        }

        return pq;
    }
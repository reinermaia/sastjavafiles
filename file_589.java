    public static <E> List<E> extractRandomSubList(Random random, List<E> list, double... thresholds) {
        int size = generateRandomIntFromThresholds(random, thresholds);
        if (size > list.size()) {
            size = list.size();
        }
        return extractRandomSubListOfSize(random, list, size);
    }
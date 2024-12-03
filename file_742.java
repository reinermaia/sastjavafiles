    public static <T extends EurekaEndpoint> List<T> randomize(List<T> list) {
        List<T> randomList = new ArrayList<>(list);
        if (randomList.size() < 2) {
            return randomList;
        }
        Random random = new Random(LOCAL_IPV4_ADDRESS.hashCode());
        int last = randomList.size() - 1;
        for (int i = 0; i < last; i++) {
            int pos = random.nextInt(randomList.size() - i);
            if (pos != i) {
                Collections.swap(randomList, i, pos);
            }
        }
        return randomList;
    }
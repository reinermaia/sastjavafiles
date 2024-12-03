    public static <T> T pickRandom (List<T> values, T skip, Random r)
    {
        int size = values.size();
        if (size < 2) {
            throw new IllegalArgumentException(
                "Must have at least two elements [size=" + size + "]");
        }

        int pick = r.nextInt(size - 1);
        for (int ii = 0; ii < size; ii++) {
            T val = values.get(ii);
            if ((val != skip) && (pick-- == 0)) {
                return val;
            }
        }
        return null;
    }
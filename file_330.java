    public static IntStreamEx of(Random random, int randomNumberOrigin, int randomNumberBound) {
        return seq(random.ints(randomNumberOrigin, randomNumberBound));
    }
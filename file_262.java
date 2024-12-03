    private static int toInt(Long l) {
        if (l <= Integer.MAX_VALUE) {
            return l.intValue();
        } else {
            return Integer.MAX_VALUE;
        }
    }
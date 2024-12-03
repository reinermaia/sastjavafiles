    public boolean fuzzyMatch(ValueNumber v1, ValueNumber v2) {
        if (REDUNDANT_LOAD_ELIMINATION) {
            return v1.equals(v2) || fromMatchingLoads(v1, v2) || haveMatchingFlags(v1, v2);
        } else {
            return v1.equals(v2);
        }
    }
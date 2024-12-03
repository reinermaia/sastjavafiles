    @Override
    public int countUnique() {
        IntSet uniqueElements = new IntOpenHashSet();
        for (int i = 0; i < size(); i++) {
            if (!isMissingValue(getInt(i))) {
                uniqueElements.add(getInt(i));
            }
        }
        return uniqueElements.size();
    }
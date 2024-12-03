    @Override
    public int countUnique() {
        DoubleSet uniqueElements = new DoubleOpenHashSet();
        for (int i = 0; i < size(); i++) {
            if (!isMissing(i)) {
                uniqueElements.add(getDouble(i));
            }
        }
        return uniqueElements.size();
    }
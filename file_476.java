    @Override
    public void forget(int from, int to) {
        if(!isObservingInputs()) { // memoization is off
            throw new IllegalStateException(
                    "There is nothing to forget, because memoization is off."
                    + " To turn memoization on, you have to be observing this"
                    + " list or its memoizedItems.");
        }

        Lists.checkRange(from, to, size());
        int memoChangeFrom = sparseList.getPresentCountBefore(from);
        List<E> memoRemoved = sparseList.collect(from, to);
        sparseList.spliceByVoid(from, to, to - from);
        memoizedItems.fireRemoveRange(memoChangeFrom, memoRemoved);
    }
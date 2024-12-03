    @Override
    public void sortAtomContainers(final Comparator<IAtomContainer> comparator) {

        // need to use boxed primitives as we can't customise sorting of int primitives
        Integer[] indexes = new Integer[atomContainerCount];
        for (int i = 0; i < indexes.length; i++)
            indexes[i] = i;

        // proxy the index comparison to the atom container comparator
        Arrays.sort(indexes, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return comparator.compare(atomContainers[o1], atomContainers[o2]);
            }
        });

        // copy the original arrays (we could modify in place with swaps but this is cleaner)
        IAtomContainer[] containersTmp = Arrays.copyOf(atomContainers, indexes.length);
        Double[] multipliersTmp = Arrays.copyOf(multipliers, indexes.length);

        // order the arrays based on the order of the indices
        for (int i = 0; i < indexes.length; i++) {
            atomContainers[i] = containersTmp[indexes[i]];
            multipliers[i] = multipliersTmp[indexes[i]];
        }

    }
    public List<T> nextPermutationAsList()
    {
        List<T> permutation = new ArrayList<T>(elements.length);
        return nextPermutationAsList(permutation);
    }
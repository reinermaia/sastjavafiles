    public Permutation multiply(Permutation other) {
        Permutation newPermutation = new Permutation(values.length);
        for (int i = 0; i < values.length; i++) {
            newPermutation.values[i] = this.values[other.values[i]];
        }
        return newPermutation;
    }
    public List<Permutation> all() {
        final List<Permutation> permutations = new ArrayList<Permutation>();
        Backtracker counter = new Backtracker() {

            @Override
            public void applyTo(Permutation p) {
                permutations.add(p);
            }

            @Override
            public boolean isFinished() {
                return false;
            }
        };
        this.apply(counter);
        return permutations;
    }
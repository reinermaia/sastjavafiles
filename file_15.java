	public void completeGroup() {
		// Copy initial set to allow permutations to grow
		List<List<Integer>> gens = new ArrayList<List<Integer>>(permutations);
		// Keep HashSet version of permutations for fast lookup.
		Set<List<Integer>> known = new HashSet<List<Integer>>(permutations);
		//breadth-first search through the map of all members
		List<List<Integer>> currentLevel = new ArrayList<List<Integer>>(permutations);
		while( currentLevel.size() > 0) {
			List<List<Integer>> nextLevel = new ArrayList<List<Integer>>();
			for( List<Integer> p : currentLevel) {
				for(List<Integer> gen : gens) {
					List<Integer> y = combine(p,gen);
					if(!known.contains(y)) {
						nextLevel.add(y);
						//bypass addPermutation(y) for performance
						permutations.add(y);
						known.add(y);
					}
				}
			}
			currentLevel = nextLevel;
		}
	}
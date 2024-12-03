	public void removePermutations(List<Integer> removed) {

		int[] permutations = new int[this.permutations.length];

		int index = 0;
		permutations:
		for (int j : this.permutations) {
			for (int i = 0; i < removed.size(); i++) {
				if(removed.get(i) == j) {
					// skip this
					removed.remove(i);

					continue permutations;
				}
			}

			permutations[index] = j;

			index++;
		}

		int[] effectivePermutations = new int[index];
		System.arraycopy(permutations, 0, effectivePermutations, 0, index);
		
		this.rotations = new int[permutations.length];
		this.reset = new int[permutations.length];
		this.permutations = effectivePermutations;
		Arrays.sort(permutations); // ascending order to make the permutation logic work
	}
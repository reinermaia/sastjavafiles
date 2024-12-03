	private void solve() {
		initialize();
		int n = subunits.getSubunitCount();
		PermutationGenerator g = new PermutationGenerator(n);

		// loop over all permutations
		while (g.hasMore()) {
			int[] perm = g.getNext();
			List<Integer> permutation = new ArrayList<Integer>(perm.length);
			for (int j = 0; j < n; j++) {
				permutation.add(perm[j]);
			}

			if (! isValidPermutation(permutation)) {
				continue;
			}

			boolean newPermutation = evaluatePermutation(permutation);
			if (newPermutation) {
				completeRotationGroup();
			}

			if (rotations.getOrder() >= subunits.getSubunitCount()) {
				return;
			}
		}
	}
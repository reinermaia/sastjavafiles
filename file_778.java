	public int randomChooseFromDistribution(double... probs) {
		int result = -1;
		int[] range = new int[probs.length];
		double accuracy = 1000;
		int total = 0;

		for (int i = 0; i < probs.length; i++) {
			range[i] = (int) (probs[i] * accuracy);
			total += range[i];
		}

		int randNum = (int) (rng.nextDouble() * total);
		for (int i = 0; i < range.length; i++) {
			randNum -= range[i];
			if (randNum <= 0) {
				result = i;
				break;
			}
		}
		return result;
	}
	static
	public double probability(ContinuousDistribution distribution, Number x){

		if(distribution instanceof GaussianDistribution){
			return probability((GaussianDistribution)distribution, x);
		} else

		if(distribution instanceof PoissonDistribution){
			return probability((PoissonDistribution)distribution, x);
		}

		throw new UnsupportedElementException(distribution);
	}
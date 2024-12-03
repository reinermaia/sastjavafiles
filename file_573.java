	static
	public double probability(GaussianDistribution gaussianDistribution, Number x){
		NormalDistribution distribution = new NormalDistribution(gaussianDistribution.getMean(), Math.sqrt(gaussianDistribution.getVariance()));

		return distribution.density(x.doubleValue());
	}
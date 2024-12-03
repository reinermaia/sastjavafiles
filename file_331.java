  public static double quantile(double x, double mu, double sigma) {
    return FastMath.exp(mu + sigma * NormalDistribution.standardNormalQuantile(x));
  }
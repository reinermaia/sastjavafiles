  public static double cdf(double x, double mu, double sigma) {
    if(x <= 0.) {
      return 0.;
    }
    return .5 * (1 + NormalDistribution.erf((FastMath.log(x) - mu) / (MathUtil.SQRT2 * sigma)));
  }
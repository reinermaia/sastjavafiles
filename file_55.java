   @Override public double normal(double mean, double sd) {
      NormalDistribution normal = new NormalDistribution(mean, sd);
      return normal.sample();
   }
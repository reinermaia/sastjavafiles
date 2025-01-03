  public static <E> Distribution<E> getDistributionFromPartiallySpecifiedCounter(Counter<E> c, int numKeys){
    Distribution<E> d;
    double total = c.totalCount();
    if (total >= 1.0){
      d = getDistribution(c);
      d.numberOfKeys = numKeys;
    } else {
      d = new Distribution<E>();
      d.numberOfKeys = numKeys;
      d.counter = c;
      d.reservedMass = 1.0 - total;
    }
    return d;
  }
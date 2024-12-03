  public static <V extends NumberVector> double logLikelihoodZhao(Relation<V> relation, Clustering<? extends MeanModel> clustering, NumberVectorDistanceFunction<? super V> distanceFunction) {
    List<? extends Cluster<? extends MeanModel>> clusters = clustering.getAllClusters();
    // number of clusters
    final int m = clusters.size();

    // number of objects in the clustering
    int n = 0;
    // cluster sizes
    int[] n_i = new int[m];
    // variances
    double[] d_i = new double[m];

    // Iterate over clusters:
    Iterator<? extends Cluster<? extends MeanModel>> it = clusters.iterator();
    for(int i = 0; it.hasNext(); ++i) {
      Cluster<? extends MeanModel> cluster = it.next();
      n += n_i[i] = cluster.size();
      // Note: the paper used 1/(n-m) but that is probably a typo
      // as it will cause divisions by zero.
      d_i[i] = varianceOfCluster(cluster, distanceFunction, relation) / (double) n_i[i];
    }

    final int dim = RelationUtil.dimensionality(relation);

    // log likelihood of this clustering
    double logLikelihood = 0.;
    // Aggregate
    for(int i = 0; i < m; i++) {
      logLikelihood += n_i[i] * FastMath.log(n_i[i] / (double) n) // ni log ni/n
          - n_i[i] * dim * .5 * MathUtil.LOGTWOPI // ni*d/2 log2pi
          - n_i[i] * .5 * FastMath.log(d_i[i]) // ni/2 log sigma_i
          - (n_i[i] - m) * .5; // (ni-m)/2
    }
    return logLikelihood;
  }
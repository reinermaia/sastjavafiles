  public double evaluateClustering(Database db, Relation<? extends NumberVector> rel, Clustering<?> c) {
    List<? extends Cluster<?>> clusters = c.getAllClusters();
    NumberVector[] centroids = new NumberVector[clusters.size()];
    int ignorednoise = centroids(rel, clusters, centroids, noiseOption);

    MeanVariance mssil = new MeanVariance();

    Iterator<? extends Cluster<?>> ci = clusters.iterator();
    for(int i = 0; ci.hasNext(); i++) {
      Cluster<?> cluster = ci.next();
      if(cluster.size() <= 1) {
        // As suggested in Rousseeuw, we use 0 for singletons.
        mssil.put(0., cluster.size());
        continue;
      }
      if(cluster.isNoise()) {
        switch(noiseOption){
        case IGNORE_NOISE:
          continue; // Ignore elements
        case TREAT_NOISE_AS_SINGLETONS:
          // As suggested in Rousseeuw, we use 0 for singletons.
          mssil.put(0., cluster.size());
          continue;
        case MERGE_NOISE:
          break; // Treat as cluster below
        }
      }

      // Cluster center:
      final NumberVector center = centroids[i];
      assert (center != null);
      for(DBIDIter it = cluster.getIDs().iter(); it.valid(); it.advance()) {
        NumberVector obj = rel.get(it);
        // a: Distance to own centroid
        double a = distance.distance(center, obj);

        // b: Distance to other clusters centroids:
        double min = Double.POSITIVE_INFINITY;
        Iterator<? extends Cluster<?>> cj = clusters.iterator();
        for(int j = 0; cj.hasNext(); j++) {
          Cluster<?> ocluster = cj.next();
          if(i == j) {
            continue;
          }
          NumberVector other = centroids[j];
          if(other == null) { // Noise!
            switch(noiseOption){
            case IGNORE_NOISE:
              continue;
            case TREAT_NOISE_AS_SINGLETONS:
              // Treat each object like a centroid!
              for(DBIDIter it2 = ocluster.getIDs().iter(); it2.valid(); it2.advance()) {
                double dist = distance.distance(rel.get(it2), obj);
                min = dist < min ? dist : min;
              }
              continue;
            case MERGE_NOISE:
              break; // Treat as cluster below, but should not be reachable.
            }
          }
          // Clusters: use centroid.
          double dist = distance.distance(other, obj);
          min = dist < min ? dist : min;
        }

        // One 'real' cluster only?
        min = min < Double.POSITIVE_INFINITY ? min : a;
        mssil.put((min - a) / (min > a ? min : a));
      }
    }

    double penalty = 1.;
    // Only if {@link NoiseHandling#IGNORE_NOISE}:
    if(penalize && ignorednoise > 0) {
      penalty = (rel.size() - ignorednoise) / (double) rel.size();
    }
    final double meanssil = penalty * mssil.getMean();
    final double stdssil = penalty * mssil.getSampleStddev();
    if(LOG.isStatistics()) {
      LOG.statistics(new StringStatistic(key + ".simplified-silhouette.noise-handling", noiseOption.toString()));
      if(ignorednoise > 0) {
        LOG.statistics(new LongStatistic(key + ".simplified-silhouette.ignored", ignorednoise));
      }
      LOG.statistics(new DoubleStatistic(key + ".simplified-silhouette.mean", meanssil));
      LOG.statistics(new DoubleStatistic(key + ".simplified-silhouette.stddev", stdssil));
    }

    EvaluationResult ev = EvaluationResult.findOrCreate(db.getHierarchy(), c, "Internal Clustering Evaluation", "internal evaluation");
    MeasurementGroup g = ev.findOrCreateGroup("Distance-based Evaluation");
    g.addMeasure("Simp. Silhouette +-" + FormatUtil.NF2.format(stdssil), meanssil, -1., 1., 0., false);
    db.getHierarchy().resultChanged(ev);
    return meanssil;
  }
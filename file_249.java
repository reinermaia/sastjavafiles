  @Override
  public Clustering<MeanModel> run(Database database, Relation<V> relation) {
    // Database objects to process
    final DBIDs ids = relation.getDBIDs();
    // Choose initial means
    double[][] means = initializer.chooseInitialMeans(database, relation, k, getDistanceFunction());
    // Setup cluster assignment store
    List<ModifiableDBIDs> clusters = new ArrayList<>();
    for(int i = 0; i < k; i++) {
      clusters.add(DBIDUtil.newHashSet(relation.size() / k + 2));
    }

    // Meta data storage
    final WritableDataStore<Meta> metas = initializeMeta(relation, means);
    // Perform the initial assignment
    ArrayModifiableDBIDs tids = initialAssignment(clusters, metas, ids);
    // Recompute the means after the initial assignment
    means = means(clusters, means, relation);
    // Refine the result via k-means like iterations
    means = refineResult(relation, means, clusters, metas, tids);

    // Wrap result
    Clustering<MeanModel> result = new Clustering<>("k-Means Samesize Clustering", "kmeans-samesize-clustering");
    for(int i = 0; i < clusters.size(); i++) {
      result.addToplevelCluster(new Cluster<>(clusters.get(i), new MeanModel(means[i])));
    }
    return result;
  }
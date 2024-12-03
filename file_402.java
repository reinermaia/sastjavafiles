    private void clusterAndAssignSenses(
            OnlineClustering<SparseDoubleVector> contexts,
            String primaryKey,
            double mergeThreshold) {
        // First forcefully condense everything down to the required
        // number of clusters.
        List<Cluster<SparseDoubleVector>> newClusters = clusterStream(
                contexts.getClusters(), numClusters, 0.0);

        // Then try to merge these new centroids based on the similarity
        // threshold.
        newClusters = clusterStream(contexts.getClusters(), 0, mergeThreshold);

        // Store a mapping for each word sense to it's induced word
        // sense, i.e., the centroid.
        synchronized(wordSpace) {
            wordSpace.put(primaryKey, newClusters.get(0).centroid());
            for (int i = 1; i < newClusters.size(); ++i)
                wordSpace.put(primaryKey+"-"+i, newClusters.get(i).centroid());
        }

        // If there is no reporter, skip any post processing.
        if (reporter == null)
            return;

        // Get the set of context labels for each data point for the
        // given word.
        String[] contextLabels = reporter.contextLabels(primaryKey);
        if (contextLabels.length == 0)
            return;

        // Output the assignments for a single clustering.
        int clusterId = 0;
        for (Cluster<SparseDoubleVector> cluster : newClusters) {
            BitSet contextIds = cluster.dataPointIds();
            for (int contextId = contextIds.nextSetBit(0); contextId >= 0;
                     contextId = contextIds.nextSetBit(contextId + 1)) {
                reporter.updateAssignment(
                        primaryKey, contextLabels[contextId], clusterId); 
            }
            clusterId++;
        }
    }
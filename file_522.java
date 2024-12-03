	protected static Clustering cleanUpKMeans(Clustering kMeansResult, ArrayList<CFCluster> microclusters) {
		/* Convert k-means result to CFClusters */
		int k = kMeansResult.size();
		CFCluster[] converted = new CFCluster[k];

		for (CFCluster mc : microclusters) {
		    // Find closest kMeans cluster
		    double minDistance = Double.MAX_VALUE;
		    int closestCluster = 0;
		    for (int i = 0; i < k; i++) {
		    	double distance = distance(kMeansResult.get(i).getCenter(), mc.getCenter());
				if (distance < minDistance) {
				    closestCluster = i;
				    minDistance = distance;
				}
		    }

		    // Add to cluster
		    if ( converted[closestCluster] == null ) {
		    	converted[closestCluster] = (CFCluster)mc.copy();
		    } else {
		    	converted[closestCluster].add(mc);
		    }
		}

		// Clean up
		int count = 0;
		for (int i = 0; i < converted.length; i++) {
		    if (converted[i] != null)
			count++;
		}

		CFCluster[] cleaned = new CFCluster[count];
		count = 0;
		for (int i = 0; i < converted.length; i++) {
		    if (converted[i] != null)
			cleaned[count++] = converted[i];
		}

		return new Clustering(cleaned);
	}
	public static Clustering kMeans_gta(int k, Clustering clustering, Clustering gtClustering) {
		
		ArrayList<CFCluster> microclusters = new ArrayList<CFCluster>();
        for (int i = 0; i < clustering.size(); i++) {
            if (clustering.get(i) instanceof CFCluster) {
                microclusters.add((CFCluster)clustering.get(i));
            } else {
                System.out.println("Unsupported Cluster Type:" + clustering.get(i).getClass() + ". Cluster needs to extend moa.cluster.CFCluster");
            }
        }
        
        int n = microclusters.size();
		assert (k <= n);
		
		/* k-means */
		Random random = new Random(0);
		Cluster[] centers = new Cluster[k];
		int K = gtClustering.size();
		
		for (int i = 0; i < k; i++) {
			if (i < K) {	// GT-aided
				centers[i] = new SphereCluster(gtClustering.get(i).getCenter(), 0);
			} else {		// Randomized
				int rid = random.nextInt(n);
				centers[i] = new SphereCluster(microclusters.get(rid).getCenter(), 0);
			}
		}
		
		return cleanUpKMeans(kMeans(k, centers, microclusters), microclusters);
	}
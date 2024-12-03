	public static double kMeans(List<double[]> centroids, List<double[]> input) {
		int k = centroids.size();
		assert (k > 0);
		int d = centroids.get(0).length;
		int size = input.size();

		double[][] center = new double[k][];
		Iterator<double[]> iIter = centroids.iterator();
		for (int i = 0; i < k; i++) {
			center[i] = iIter.next();
		}

		double[][] newCenter = new double[k][d];
		double[] newCenterWeight = new double[k];
		int[] nearestCluster = new int[size];
		boolean converged;
		do {
			for (int i = 0; i < k; i++) {
				for (int j = 0; j < d; j++) {
					newCenter[i][j] = 0.0;
				}
				newCenterWeight[i] = 0.0;
			}
			Iterator<double[]> lIter = input.iterator();
			for (int l = 0; l < size; l++) {
				// Calculates the distance from all points to all centroids
				double[] point = lIter.next();
				assert (d == point.length - 1);
				double minDistance = Double.POSITIVE_INFINITY;
				int closestCluster = -1;
				for (int i = 0; i < k; i++) {
					double distance = Metric.distance(center[i], point, 1);
					if (distance < minDistance) {
						closestCluster = i;
						minDistance = distance;
					}
				}

				// Sums up all points for the new centroids
				assert (closestCluster >= 0 && closestCluster < k);
				for (int j = 0; j < d; j++) {
					newCenter[closestCluster][j] += point[0] * point[j + 1];
				}
				newCenterWeight[closestCluster] += point[0];
				nearestCluster[l] = closestCluster;
			}

			// Calculates the new centroids
			converged = true;
			for (int i = 0; i < k; i++) {
				for (int j = 0; j < d; j++) {
					if (newCenterWeight[i] != 0.0) {
						double newValue = newCenter[i][j] / newCenterWeight[i];
						if (newValue != center[i][j]) {
							converged = false;
						}
						center[i][j] = newValue;
					}
				}
			}
		} while (!converged);
		// Replaces the old centroids with the new ones
		for (int i = 0; i < k; i++) {
			centroids.set(i, center[i]);
		}

		// Calculates the costs of the solution
		double costs = 0.0;
		Iterator<double[]> lIter = input.iterator();
		for (int l = 0; l < size; l++) {
			double[] point = lIter.next();
			costs += point[0]
					* Metric.distanceSquared(center[nearestCluster[l]], point,
							1);
		}
		return costs;
	}
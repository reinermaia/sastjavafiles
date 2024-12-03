	private void makeConfusionMatrix(Map<String, String> actual, Map<String, String> predicted) {
		confusion = new int[categories.size()][categories.size()];
		for (String k: predicted.keySet()) {
			for (int i=0; i<categories.size(); ++i) {
				String ci = categories.get(i);
				for (int j=0; j<categories.size(); ++j) {
					String cj = categories.get(j);
					if (ci.equals(actual.get(k)) && cj.equals(predicted.get(k))) {
						confusion[i][j]++;
					}
				}
			}
		}
	}
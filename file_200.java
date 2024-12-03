    private void calcMedian(List<Double> data) {
	if ((data.size() % 2) == 0) {
	    median = data.get(data.size() / 2);
	} else {
	    median = data.get(data.size() / 2 - 1);
	    median += data.get(data.size() / 2);
	    median /= 2.0;
	}
    }
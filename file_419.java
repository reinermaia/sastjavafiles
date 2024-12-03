	public long getElapsedSeconds() {
		long elapsed;
		if (running) {
			elapsed = (System.nanoTime() - startTime);
		} else {
			elapsed = (stopTime - startTime);
		}
		return elapsed / nsPerSs;
	}
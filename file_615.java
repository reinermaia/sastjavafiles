	public Path withFile(final String file) {
		final Path result = new Path(this);
		result.setFile(file);
		return result;
	}
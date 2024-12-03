	private <T> List<T> extractRandomList(List<T> elements, int count) {
		random.shuffle(elements);
		return elements.subList(0, count);
	}
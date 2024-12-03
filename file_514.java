	public <T> List<T> randomElements(List<T> elements, int count) {
		if (elements.size() >= count) {
			return extractRandomList(elements, count);
		} else {
			List<T> randomElements = new ArrayList<T>();
			randomElements.addAll(extractRandomList(elements, count % elements.size()));
			do {
				randomElements.addAll(extractRandomList(elements, elements.size()));
			} while (randomElements.size() < count);
			return randomElements;
		}
	}
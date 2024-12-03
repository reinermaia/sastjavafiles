	public static <E> PriorityQueue<E> newPriorityQueue(PriorityQueue<? extends E> priorityQueue) {
		return new PriorityQueue<E>(priorityQueue);
	}
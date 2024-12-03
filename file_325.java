	@SuppressWarnings("unchecked")
	@Override
	public PriorityQueue readObject(OInput in, Class<PriorityQueue> clazz) throws IOException {
		int size = NaturalNumberIoHelper.readNaturalNumber(in);
		
		Comparator comparator = (Comparator)in.readObject();
		PriorityQueue queue = new PriorityQueue(size, comparator);
		
		for(int i=0 ; i<size ; i++) {
			queue.add(in.readObject());
		}
		
		return queue;
	}
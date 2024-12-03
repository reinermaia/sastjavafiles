	private void printSummary(PMML pmml){
		MemoryMeasurer measurer = new MemoryMeasurer();
		measurer.applyTo(pmml);

		NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
		numberFormat.setGroupingUsed(true);

		long size = measurer.getSize();
		System.out.println("Bytesize of the object graph: " + numberFormat.format(size));

		Set<Object> objects = measurer.getObjects();
		System.out.println("Number of distinct Java objects in the object graph: " + numberFormat.format(objects.size()));
	}
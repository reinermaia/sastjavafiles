	public void scatterPlot(Matrix matrix, String... format) throws Exception {
		matrix.exportTo().file(matrixFile).asDenseCSV();
		execute(getPlotCommand(matrix, false, false));
	}
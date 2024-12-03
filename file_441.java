	public Matrix predictOne(Matrix input) {
		// transpose and add bias unit
		// Matrix inputWithBias = Matrix.zeros(input.getColumnCount() + 1,
		// input.getRowCount());
		// for (long i = input.getColumnCount() - 1; i != -1; i--) {
		// inputWithBias.setDouble(input.getDouble(0, i), i, 0);
		// }
		// inputWithBias.setDouble(1.0, inputWithBias.getRowCount() - 1, 0);
		addInputMatrix(input);

		for (NetworkLayer networkLayer : getNetworkLayerList()) {
			networkLayer.calculateForward();
		}

		Matrix actualOutput = getOutputMatrix().transpose();
		return actualOutput;
	}
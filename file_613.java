	public void writeSummary(String s) {
		if (summaryWriter != null) {
			summaryWriter.println(s);
		}

		logger.info(s);
	}
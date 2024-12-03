	public static String getCurrentDate() {
		long now = System.currentTimeMillis();

		if ((now - currentDateGenerated) > 1000) {
			synchronized (format) {
				if ((now - currentDateGenerated) > 1000) {
					currentDateGenerated = now;
					currentDate = format.format(new Date(now));
				}
			}
		}

		return currentDate;
	}
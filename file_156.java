	private boolean convertToBoolean(Object o) {
		if (o.getClass() == Boolean.class) {
			return (Boolean) o;
		}
		else {
			return Boolean.parseBoolean(o.toString());
		}
	}
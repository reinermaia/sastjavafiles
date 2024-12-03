	public Priority setPriority(Integer priority) {
		Priority prop = (priority == null) ? null : new Priority(priority);
		setPriority(prop);
		return prop;
	}
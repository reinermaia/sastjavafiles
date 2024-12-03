	public UniqueModel unique() {
		checkReadOnly();
		UniqueModel unique = new UniqueModel();
		unique.setTableModel(this);
		getUniqueConsts().add(unique);
		return unique;
	}
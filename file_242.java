	protected void readOnlyUpdated() {
		boolean localReadOnly = isReadOnly();
		if (hasChanged(oldReadOnly, localReadOnly)) {
			oldReadOnly = localReadOnly;
			firePropertyChange(READONLY_PROPERTY, !localReadOnly, localReadOnly);
		}
	}
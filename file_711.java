    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
        firePropertyChange(READ_ONLY_PROPERTY, oldReadOnly, isReadOnly());
        oldReadOnly = isReadOnly();
    }
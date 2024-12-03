    @Deprecated
    public void setHidden(final Boolean hidden) {
        if (hidden == null) {
            setAttributeValue(null);
        } else {
            setAttributeValue(
                    hidden.booleanValue() ? "hidden" : String.valueOf(hidden));
        }
        this.hidden = hidden;
    }
    public List<IHidden> getHidden()
    {
        for (final IHidden hidden : this.hidden) {
            hidden.setAdded(false);
        }
        return this.hidden;
    }
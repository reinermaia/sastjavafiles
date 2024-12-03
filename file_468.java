    public void setHidden(final boolean hidden) {
        if (hidden)
            attrMixin.setAttribute(HIDDEN, Boolean.toString(true));
        else
            attrMixin.removeAttribute(HIDDEN);
    }
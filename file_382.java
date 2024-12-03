    protected JCheckBox addCheckBox(final E item, final boolean checked) {
        final String name = getName(item);
        DCCheckBox<E> checkBox = _checkBoxes.get(name);
        if (checkBox != null) {
            checkBox.setSelected(checked);
            return checkBox;
        }
        checkBox = new DCCheckBox<>(name, checked);
        checkBox.setValue(item);
        checkBox.setOpaque(false);
        checkBox.addListener(_changeListener);
        _checkBoxes.put(name, checkBox);
        add(checkBox);

        updateVisibility();
        updateUI();

        return checkBox;
    }
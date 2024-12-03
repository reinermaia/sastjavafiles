    private JCheckBox createCheckBox(final String label, final boolean selected) {
        final JCheckBox checkBox = new JCheckBox(label, selected);
        checkBox.setOpaque(false);
        checkBox.setForeground(WidgetUtils.BG_COLOR_BRIGHTEST);
        checkBox.addItemListener(item -> onSettingsUpdated(false));

        return checkBox;
    }
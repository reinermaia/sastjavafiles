    private void check(CheckBox checkBox) {
        if (checkBox.getValue()) {
            selectedListItems.add(checkBox.getText());
            checkBox.addStyleName(STYLE_CHECKBOXLIST_ITEM_CHECKED);
            clearSelectionControl.setVisible(true);
        } else {
            removeItem(checkBox.getText());
            checkBox.removeStyleName(STYLE_CHECKBOXLIST_ITEM_CHECKED);
            if (selectedListItems.size() == 0) {
                clearSelectionControl.setVisible(false);
            }
        }
    }
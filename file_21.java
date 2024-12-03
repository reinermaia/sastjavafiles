    public void uncheckCheckboxInCell(int row, int column) {
        String checkboxLocator = getXPathBase() + "tr[" + row + "]/td[" + column + "]/input";
        CheckBox cb = new CheckBox(checkboxLocator);
        cb.uncheck();
    }
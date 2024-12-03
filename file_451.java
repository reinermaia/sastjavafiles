    protected Widget addMarker(String text) {

        Label label = new Label(text);
        label.addStyleName(CSS.marker());
        getListItemWidget().addButton(label);
        return label;
    }
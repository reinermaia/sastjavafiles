    public void setLabelText(String text) {
        mLabelText = text;
        TextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setText(text);
        }
    }
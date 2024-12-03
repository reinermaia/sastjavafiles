    private void cut(XYChartLabel label, double maxWidth, double maxHeight, double rotation)
    {
        String text = label.getLabel().getText();

        // Cut text.
        cutLabelText(label, maxWidth - 5, maxHeight - 5, rotation);

        String cutText = label.getLabel().getText();

        // If text is cut, add suffix characters.
        if (text.length() != cutText.length())
        {
            label.getLabel().setText(label.getLabel().getText() + "...");
        }
        // TODO: Animate.
        // animate(label, text, cutText, originalRotation);

        // Move label to top.
        label.getLabelContainer().moveToTop();
    }
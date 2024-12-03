    @Override
    protected void handlePlainTextLine(final String plainTextLine) {
        final Label label = getLabel();
        final String textToAppend = getParser().parseString(plainTextLine, label);
        if (Strings.isEmpty(label.getText())) {
            // Label is currently empty, so we just set the text as initial value.
            label.setText(textToAppend);
        } else {
            if (LmlUtilities.isMultiline(label)) {
                // Label is multiline. We might want to append an extra new line char.
                label.getText().append('\n');
            }
            label.getText().append(textToAppend);
        }
        label.invalidate();
    }
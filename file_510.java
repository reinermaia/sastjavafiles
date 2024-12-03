    private void setUpTextView11(View view) {
        // Setup single span
        TextView tv11 = (TextView) view.findViewById(R.id.tv11);

        CharSequence formattedText11 = Trestle.getFormattedText(
                new Span.Builder("Regex - ForegroundColorSpan, BackgroundColorSpan, and CustomTypefaceSpan (case insensitive)")
                        .regex(new Regex("(", Regex.CASE_INSENSITIVE))
                        .foregroundColor(getContext(), R.color.green_500)
                        .backgroundColor(getContext(), R.color.red_200)
                        .typeface(boldItalicFont)
                        .build());

        tv11.setText(formattedText11);
    }
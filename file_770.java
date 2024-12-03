	private WDecoratedLabel makeHeadingLabel(final String text, final String statusText) {
		return new WDecoratedLabel(new WImage("/image/information.png", "Informative heading"),
				new WText(text), new WStyledText(statusText, WStyledText.Type.EMPHASISED));
	}
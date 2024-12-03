    private void convertHTMLCode(ArrayList<ArrayList<TextPiece>> wordsByPage) {
	DocInfo docInfo = new DocInfo();
	String[] html2Char = docInfo.getHtml2CharMapping(); // Only define this
							    // mapping string
							    // when we detect
							    // the files in HTML
							    // codes
	int pageNum = 0;

	for (ArrayList<TextPiece> wordsOfAPage : wordsByPage) {
	    pageNum++;
	    for (int i = 0; i < wordsOfAPage.size(); i++) {
		TextPiece currentWord = wordsOfAPage.get(i);
		String realText = "";
		String textinHTMLCode = currentWord.getText();

	    }
	}
    }
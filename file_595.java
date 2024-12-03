    public void parse(Page page, String contextURL) throws NotAllowedContentException, ParseException {
        if (Util.hasBinaryContent(page.getContentType())) { // BINARY
            BinaryParseData parseData = new BinaryParseData();
            if (config.isIncludeBinaryContentInCrawling()) {
                if (config.isProcessBinaryContentInCrawling()) {
                    try {
                        parseData.setBinaryContent(page.getContentData());
                    } catch (Exception e) {
                        if (config.isHaltOnError()) {
                            throw new ParseException(e);
                        } else {
                            logger.error("Error parsing file", e);
                        }
                    }
                } else {
                    parseData.setHtml("<html></html>");
                }
                page.setParseData(parseData);
                if (parseData.getHtml() == null) {
                    throw new ParseException();
                }
                parseData.setOutgoingUrls(net.extractUrls(parseData.getHtml()));
            } else {
                throw new NotAllowedContentException();
            }
        } else if (Util.hasCssTextContent(page.getContentType())) { // text/css
            try {
                CssParseData parseData = new CssParseData();
                if (page.getContentCharset() == null) {
                    parseData.setTextContent(new String(page.getContentData()));
                } else {
                    parseData.setTextContent(
                        new String(page.getContentData(), page.getContentCharset()));
                }
                parseData.setOutgoingUrls(page.getWebURL());
                page.setParseData(parseData);
            } catch (Exception e) {
                logger.error("{}, while parsing css: {}", e.getMessage(), page.getWebURL().getURL());
                throw new ParseException();
            }
        } else if (Util.hasPlainTextContent(page.getContentType())) { // plain Text
            try {
                TextParseData parseData = new TextParseData();
                if (page.getContentCharset() == null) {
                    parseData.setTextContent(new String(page.getContentData()));
                } else {
                    parseData.setTextContent(
                        new String(page.getContentData(), page.getContentCharset()));
                }
                parseData.setOutgoingUrls(net.extractUrls(parseData.getTextContent()));
                page.setParseData(parseData);
            } catch (Exception e) {
                logger.error("{}, while parsing: {}", e.getMessage(), page.getWebURL().getURL());
                throw new ParseException(e);
            }
        } else { // isHTML

            HtmlParseData parsedData = this.htmlContentParser.parse(page, contextURL);

            if (page.getContentCharset() == null) {
                page.setContentCharset(parsedData.getContentCharset());
            }

            // Please note that identifying language takes less than 10 milliseconds
            LanguageIdentifier languageIdentifier = new LanguageIdentifier(parsedData.getText());
            page.setLanguage(languageIdentifier.getLanguage());

            page.setParseData(parsedData);

        }
    }
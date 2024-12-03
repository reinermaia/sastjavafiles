	public ExtractResult extract(String content, String selector, int amount) {

		List<Element> extracted = extractElements(content, selector, amount);

		if (extracted.size() > 1) {

			// first element is the remaining body, the rest are extracted
			Element body = extracted.get(0);
			List<Element> elements = extracted.subList(1, extracted.size());

			// convert to HTML
			List<String> elementStr = new ArrayList<String>();
			for (Element el : elements) {
				elementStr.add(el.outerHtml());
			}

			return new DefaultExtractResult(elementStr, body.html());
		} else {
			// nothing to extract
			return new DefaultExtractResult(Collections.<String> emptyList(), content);
		}
	}
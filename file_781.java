	private void readInnerText(UnprotectedStringBuffer innerText, AsyncWork<UnprotectedStringBuffer, Exception> result) {
		ISynchronizationPoint<Exception> next = next();
		do {
			if (next.isUnblocked()) {
				if (!check(next, result)) return;
				if (Type.COMMENT.equals(event.type)) {
					next = next();
					continue;
				}
				if (Type.TEXT.equals(event.type)) {
					innerText.append(event.text);
					next = next();
					continue;
				}
				if (Type.START_ELEMENT.equals(event.type)) {
					if (event.isClosed) {
						next = next();
						continue;
					}
					closeElement().listenAsync(new ParsingTask(() -> {
						readInnerText(innerText, result);
					}), result);
					return;
				}
				if (Type.END_ELEMENT.equals(event.type)) {
					result.unblockSuccess(innerText);
					return;
				}
				next = next();
				continue;
			}
			break;
		} while (true);
		next.listenInline(() -> {
			if (Type.START_ELEMENT.equals(event.type)) {
				if (event.isClosed) {
					new ParsingTask(() -> { readInnerText(innerText, result); }).start();
					return;
				}
				closeElement().listenAsync(new ParsingTask(() -> {
					readInnerText(innerText, result);
				}), result);
				return;
			}
			if (Type.COMMENT.equals(event.type)) {
				new ParsingTask(() -> { readInnerText(innerText, result); }).start();
				return;
			}
			if (Type.TEXT.equals(event.type)) {
				innerText.append(event.text);
				new ParsingTask(() -> { readInnerText(innerText, result); }).start();
				return;
			}
			if (Type.END_ELEMENT.equals(event.type)) {
				result.unblockSuccess(innerText);
				return;
			}
			new ParsingTask(() -> { readInnerText(innerText, result); }).start();
		}, result);
	}
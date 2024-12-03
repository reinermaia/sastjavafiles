	protected void readLine(int lineNumber, String line) throws LineException {
		Matcher matcher = getAcceptedLinePattern().matcher(line);
		if (matcher.find()){
			processLine(lineNumber, line, matcher);
		} else {
			if(!isHeaderLine(line)){
				throw new LineException(lineNumber, line, new Exception("Cannot parse line, unexpected structure"), false);
			}
		}
	}
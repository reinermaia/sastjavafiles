    protected void readLines(){
    	lineNumber = lineReader.getCurrentLineNumber();
		String line = lineReader.getCurrentLine();
		if (line != null && line.length() > 0) {
			// Remove double spaces.
			line = FlatFileUtils.shrink(line);
			readLine(line);
		}
    }
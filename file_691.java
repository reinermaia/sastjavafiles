    public void getValue(StringBuffer res) throws SigarException {
        String line, lastLine = "";
        try {
            while ((line = getReader().readLine()) != null) {
                log.debug("Read line: " + line);
                lastLine = line;
            }
            res.append(lastLine);
        } catch (IOException e) {
            log.error("Cannot read lines from file: " + filename);
        }
    }
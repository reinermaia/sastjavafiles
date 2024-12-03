    private StartArgs doParse(final String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options(), args);
        return parseArgs(cmd);
    }
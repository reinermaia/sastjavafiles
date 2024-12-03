    private CommandLine parseArgs(String[] args) throws ParseException {
        final CommandLineParser parser = new DefaultParser();
        final Options options = createCommandLineOptions();
        return parser.parse(options, args);
    }
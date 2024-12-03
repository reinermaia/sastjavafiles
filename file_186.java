    CommandLine parse(DefaultCommandLine cl, String[] args) {
        parseInternal(cl, args, true);
        return cl;
    }
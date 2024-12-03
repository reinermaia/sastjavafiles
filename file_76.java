    private void parseCommandLineArgs(String[] args) throws ConfigurationException {
        if (args == null || args.length == 0) {
            return;
        }
        logger.info("Parsing command line arguments");
        m_commandLineArgs = args;
        
        try {
            for (int inx = 0; inx < args.length; inx++) {
                String arg = args[inx];
                if (arg.equals("-?") || arg.equalsIgnoreCase("-h") || arg.equalsIgnoreCase("-help")) {
                    System.out.println("See documentation and doradus.yaml for help.");
                    System.exit(0);
                }
                Utils.require(arg.charAt(0) == '-', "Unrecognized argument: %s", arg);
                Utils.require(inx + 1 < args.length, "A value is expected after: %s", arg);
                String name = arg.substring(1);
                String value = args[++inx];
                setCommandLineParam(name, value);
            }
        } catch (Exception e) {
            logger.error("Failed to parse command line arguments", e);
            throw new ConfigurationException("Failed to parse command line arguments", e);
        }
    }
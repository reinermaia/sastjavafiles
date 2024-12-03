    private static void parseCommandLineArgs(String[] args) throws ConfigurationException {

        if (args[0].equalsIgnoreCase("-?") || args[0].equalsIgnoreCase("-h")
                || args[0].equalsIgnoreCase("/?") || args[0].equalsIgnoreCase("-help")) {
            System.out.println("See documentation and doradus.yaml and options");
            System.exit(0);
        }

        List<String> unknownArgs = new ArrayList<String>();

        for (int inx = 0; inx < args.length; inx++) {
            String name = args[inx].substring(1);
            if (inx + 1 >= args.length) {
                throw new ConfigurationException("A value is expected after: " + args[inx]);
            }
            String value = args[++inx];
            if (!setParamFromString(name, value)) {
                unknownArgs.add(name);
            }
        }

        if (!unknownArgs.isEmpty()) {
            StringBuilder b = new StringBuilder();
            for (String arg : unknownArgs) {
                b.append("\"" + arg + "\" ");
            }

            throw new ConfigurationException("Couldn't parse argument(s): " + b.toString());
        }
    }
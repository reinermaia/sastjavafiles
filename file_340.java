    public static void main(String[] args) throws IOException {

        Arguments arguments = new Arguments().parse(args);

        if (arguments.isUseCommonsLang3()) {
            System.err.println("--commons-lang3 is deprecated. Please remove the argument from your command-line arguments.");
        }

        Jsonschema2Pojo.generate(arguments);
    }
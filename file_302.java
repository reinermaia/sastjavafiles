    public void parse(String arg) {
        if (super.parseArg(arg))
            return;
        if (arg.startsWith(Main.STDOUT_PREFIX)) {
            //Ignore this
        } else if (srcFile == null) {
            srcFile = new File(arg);
        } else {
            setInvalid(format("JSCover: Extra command line argument found '%s'", arg));
        }
    }
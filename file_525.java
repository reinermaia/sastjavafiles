    public static Pattern convertObjectNameRegex(String regex) {
        String jRegex = regex.replace("#", "[0-9]+").replace("*", ".*");
        return Pattern.compile(jRegex);
    }
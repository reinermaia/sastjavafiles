    public static String createLikeRegex(String expr, boolean ignoreCase)
    {
        String regex = createRegex(expr, ignoreCase);
        regex = regex.replace("_", ".").replace("%", ".*?");

        return regex;
    }
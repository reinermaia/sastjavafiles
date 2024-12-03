    public static boolean matchRegex(String str, String regex) {
        try {
            return str.matches(regex);
        } catch (PatternSyntaxException e) {
            log.error("regex syntax error : {}", regex);
            return false;
        }
    }
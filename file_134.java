    private static boolean matchRuleRegex(String regex, String value) {

        if (value == null) {
            value = "";
        }

        if (regex == null) {
            return true;
        }
        if ((regex.length() > 0) && (regex.charAt(0) == '!')) {
            return !value.matches(regex.substring(1));
        } else {
            return value.matches(regex);
        }
    }
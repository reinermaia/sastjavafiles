    public static int indexOfIgnoreCase(String text, String str, int startIndex) {
        Matcher m = Pattern.compile(Pattern.quote(str), Pattern.CASE_INSENSITIVE).matcher(text);
        return m.find(startIndex) ? m.start() : -1;
    }
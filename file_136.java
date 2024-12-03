    public static int findString(String matchString, int startIndex, char[] line) {
        return findChars(FastStringUtils.toCharArray(matchString), startIndex, line);
    }
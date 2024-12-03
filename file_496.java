    public static String normalizeWord(String word) {
        return WORD_LIST.containsKey(word) ? WORD_LIST.get(word) : word;
    }
    public static boolean isValidIP4Word(String word) {
        char c;
        if (word.length() < 1 || word.length() > 3)
            return false;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (!(c >= '0' && c <= '9'))
                return false;
        }
        if (Integer.parseInt(word) > 255)
            return false;
        return true;
    }
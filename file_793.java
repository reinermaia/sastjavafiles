    public static double similarDamerauLevenshtein(String s1, String s2) {
        if (s1.equals(s2)) {
            return 1.0;
        }

        // Make sure s1 is the longest string
        if (s1.length() < s2.length()) {
            String swap = s1;
            s1 = s2;
            s2 = swap;
        }

        int bigLength = s1.length();
        return (bigLength - getDamerauLevenshteinDistance(s2, s1)) / (double) bigLength;
    }
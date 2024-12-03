    @SuppressWarnings({"MethodWithMultipleReturnPoints", "LabeledStatement", "ValueOfIncrementOrDecrementUsed", "ContinueStatement", "ContinueStatementWithLabel"})
    public static int indexOf(char[] src, char[] find, int startAt) {
        int startPos = startAt;
        final int max = src.length - find.length;
        if (startPos > max) {
            return -1;
        }
        final char find0 = find[0];
        final int len = find.length;
        int j;
        int k;

        // Find the first character
        startOver:
        while (startPos <= max) {
            if (src[startPos++] == find0) {
                // First character found - look for the rest
                j = startPos;
                k = 1;
                while (k < len) {
                    if (src[j++] != find[k++]) {
                        continue startOver;
                    }
                }
                return startPos - 1;
            }
        }
        return -1;
    }
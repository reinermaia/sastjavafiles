    private static String numToString(int num, int width) {
        String str = Integer.toString(num);
        int len = str.length();
        if (len >= width) {
            return str.substring(len - width, len);
        }
        StringBuilder sb = new StringBuilder(width);
        for (int i = len; i < width; i++) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }
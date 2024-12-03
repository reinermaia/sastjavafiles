    public static String reverse(final String str) {
        if (N.isNullOrEmpty(str)) {
            return str;
        }

        final StringBuilder sb = Objectory.createStringBuilder();

        try {
            sb.append(str);

            return sb.reverse().toString();
        } finally {
            Objectory.recycle(sb);
        }
    }
    private static void similar_str(String txt1, int len1, String txt2, int len2, Tuple t) {
        t.setMax(0);
        for (int p = 0; p < len1; ++p) {
            for (int q = 0; q < len2; ++q) {
                int l;
                for (l = 0; (p+l < len1) && (q+l < len2) && (txt1.charAt(p+l) == txt2.charAt(q+l)); ++l) {
                    
                }
                if (l > t.getMax()) {
                    t.setMax(l);
                    t.setPos1(p);
                    t.setPos2(q);
                }
            }
        }
    }
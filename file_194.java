    public static double stringSimilarity( String s1, String s2, SIMILARITY_STRATS method ) {
        switch ( method ) {
            case DICE:
            default: return stringSimilarityDice( s1, s2 );
        }
    }
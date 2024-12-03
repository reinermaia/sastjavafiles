    private boolean useThisWord(Integer wordID, Map<Integer, String> ID2word, Map<Integer, Double> ID2occurrences) {
        String word = ID2word.get(wordID);
        if(word==null) {
            return false;
        }
        else if(word.length() < parameters.getMinWordLength()) {
            return false;
        }
        else if(ID2occurrences.get(wordID)<parameters.getMinWordOccurrence()) {
            return false;
        }
        return true;
    }
    private static int wordsWithThreeSyllables(String strText) {
        int intLongWordCount = 0;
        
        List<String> arrWords = (new WhitespaceTokenizer()).tokenize(strText);
        int intWordCount = arrWords.size();
        for (int i = 0; i < intWordCount; ++i) {
            if(syllableCount(arrWords.get(i)) > 2) {
                ++intLongWordCount; //it also counts the proper nouns which should be excluded for Fog index, but this is not a major issue
            }
        }
        
        return intLongWordCount;
    }
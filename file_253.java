    private static boolean detectNameWordInSentenceByPosition(final List<Token> _text, final int _pos) {
        boolean isFirstWord = false;
        boolean nextWordIsName = false;
        if (_pos == 0 || !isLetterOrDigit((_text.get(_pos - 1).text.charAt(0)))) {
            isFirstWord = true;
            //noinspection SimplifiableIfStatement
            if (_text.size() > _pos + 1) {
                final String plus1 = _text.get(_pos + 1).text;
                nextWordIsName = ("of".equalsIgnoreCase(plus1) || "'s".equalsIgnoreCase(plus1))
                                 ? ((_text.size() > (_pos + 2)) && isName(_text.get(_pos + 2).text, false, false))
                                 : isName(plus1, false, false);
            }
            else nextWordIsName = false;
        }
        //noinspection UnnecessaryLocalVariable
        final boolean isName = isName(_text.get(_pos).text, isFirstWord, nextWordIsName);

        /*
        String wordType = dict.checkup(Strings.toEngLowerCase(_text.get(_pos));
        if (isFirstWord && !isName && wordType != null && wordType.startsWith("JJ")) {
            // if the first word is determined not to be a name but it is an adj.,
            // and if the second word is a name, we consider the first word to be a name as well.
            if (isName(_text.get(_pos + 1), false))
                return true;
        }
        */

        return isName;
    }
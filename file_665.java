    public synchronized List<String> suggest(String word) {
        requireValidHandle();
        if (!isValidInput(word)) {
            return Collections.emptyList();
        }
        Pointer voikkoSuggestCstr = getLib().voikkoSuggestCstr(handle, s2n(word));
        if (voikkoSuggestCstr == null) {
            return Collections.emptyList();
        }
        Pointer[] pointerArray = voikkoSuggestCstr.getPointerArray(0);
        List<String> suggestions = new ArrayList<String>(pointerArray.length);
        for (Pointer cStr : pointerArray) {
            suggestions.add(stringFromPointer(cStr));
        }
        getLib().voikkoFreeCstrArray(voikkoSuggestCstr);
        return suggestions;
    }
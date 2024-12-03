    public static String sort(String list, String sortType, String sortOrder, String delimiter) throws PageException {
	return _sort(toStringArray(listToArray(list, delimiter)), sortType, sortOrder, delimiter);
    }
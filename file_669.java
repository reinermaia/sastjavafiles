    @Override
    public String sortIgnoreEmpty(String list, String sortType, String sortOrder, String delimiter) throws PageException {
	return lucee.runtime.type.util.ListUtil.sortIgnoreEmpty(list, sortType, sortOrder, delimiter);
    }
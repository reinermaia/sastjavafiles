    public ListSort getSort() {
        if (sort == null) {
            sort = new ListSort(null, ListSort.SortDirection.ASC);
        }
        return sort;
    }
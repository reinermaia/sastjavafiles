    private List decodeSort(String value) {
        ArrayList sorts = new ArrayList();

        String[] nameAndSorts = value.split(DELIM_GRID_NAME);
        if(nameAndSorts.length != 2)
            return null;

        String namespace = nameAndSorts[0];
        String[] sortStrings = nameAndSorts[1].split(DELIM_SORT_TERM);

        // find the list of sorted columns
        // two columns of the bugs grid would be sorted as:
        //
        // netui_sort=bugs~id,-priority
        for(int i = 0; i < sortStrings.length; i++) {
            String sort = sortStrings[i];
            SortDirection sortDirection = SortDirection.NONE;
            if(sort.startsWith("-"))
                sortDirection = SortDirection.DESCENDING;
            else
                sortDirection = SortDirection.ASCENDING;
            String sortExpression = (sortDirection == SortDirection.DESCENDING ? sort.substring(1) : sort);
            Sort gridSort = _config.createSort();
            gridSort.setSortExpression(sortExpression);
            gridSort.setDirection(sortDirection);
            sorts.add(gridSort);
        }

        return sorts;
    }
    @Override
    public void _groupByCount(String projectedName) {
        assertNoRawQuery();
        isGroupBy = true;

        selectTokens.add(GroupByCountToken.create(projectedName));
    }
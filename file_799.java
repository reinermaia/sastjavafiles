    @Override
    public IntermediateQuery optimize(IntermediateQuery query) throws EmptyQueryException {
        IntermediateQuery optimizedQuery = super.optimize(query);
        log.trace("New query after union flattening: \n" + optimizedQuery.toString());
        return optimizedQuery;
    }
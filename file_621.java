    protected QueryBuilder convertFuzzyQuery(final QueryContext context, final FuzzyQuery fuzzyQuery, final float boost) {
        final Term term = fuzzyQuery.getTerm();
        final String field = getSearchField(context, term.field());
        // TODO fuzzy value
        if (Constants.DEFAULT_FIELD.equals(field)) {
            context.addFieldLog(field, term.text());
            return buildDefaultQueryBuilder((f, b) -> QueryBuilders.fuzzyQuery(f, term.text())
                    .fuzziness(Fuzziness.fromEdits(fuzzyQuery.getMaxEdits())).boost(b * boost));
        } else if (isSearchField(field)) {
            context.addFieldLog(field, term.text());
            return QueryBuilders.fuzzyQuery(field, term.text()).boost(boost).fuzziness(Fuzziness.fromEdits(fuzzyQuery.getMaxEdits()));
        } else {
            final String origQuery = fuzzyQuery.toString();
            context.addFieldLog(Constants.DEFAULT_FIELD, origQuery);
            context.addHighlightedQuery(origQuery);
            return buildDefaultQueryBuilder((f, b) -> QueryBuilders.fuzzyQuery(f, origQuery)
                    .fuzziness(Fuzziness.fromEdits(fuzzyQuery.getMaxEdits())).boost(b * boost));
        }
    }
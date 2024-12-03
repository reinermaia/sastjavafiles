    public NumberExpression<Long> countDistinct() {
        if (countDistinct == null) {
            countDistinct = Expressions.numberOperation(Long.class, Ops.AggOps.COUNT_DISTINCT_AGG, mixin);
        }
        return countDistinct;
    }
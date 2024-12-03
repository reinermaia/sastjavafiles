    public static <Key, Value, DistinctType> Aggregation<Key, Value, Set<DistinctType>> distinctValues() {
        AggType<Key, Value, Integer, DistinctType, Set<DistinctType>, Set<DistinctType>, Set<DistinctType>> aggType;
        aggType = new DistinctValuesAggregation<Key, Value, DistinctType>();
        return new AggregationAdapter<Key, Value, Set<DistinctType>>(aggType);
    }
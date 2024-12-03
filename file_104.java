    @Override
    public Collator<Map.Entry<Integer, Set<DistinctType>>, Set<DistinctType>> getCollator() {
        return new Collator<Map.Entry<Integer, Set<DistinctType>>, Set<DistinctType>>() {

            @Override
            public Set<DistinctType> collate(Iterable<Map.Entry<Integer, Set<DistinctType>>> values) {
                Set<DistinctType> distinctValues = new HashSet<DistinctType>();
                for (Map.Entry<Integer, Set<DistinctType>> value : values) {
                    distinctValues.addAll(value.getValue());
                }
                return distinctValues;
            }
        };
    }
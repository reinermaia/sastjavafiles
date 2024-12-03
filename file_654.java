    public LoadBalancerFilter descriptionContains(String... subStrings) {
        allItemsNotNull(subStrings, "Load balancer description subStrings");

        predicate = predicate.and(combine(
                LoadBalancerMetadata::getDescription, in(asList(subStrings), Predicates::containsIgnoreCase)
        ));

        return this;
    }
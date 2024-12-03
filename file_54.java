    public TemplateFilter descriptionContains(String... substrings) {
        allItemsNotNull(substrings, "Template description substrings");

        predicate = predicate.and(combine(
            TemplateMetadata::getDescription, in(asList(substrings), Predicates::containsIgnoreCase)
        ));

        return this;
    }
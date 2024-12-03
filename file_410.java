    @Override
    public void describeMismatchSafely(final Iterable<? extends E> actual, final Description mismatchDescription) {
        final Set<E> elements = new HashSet<>();
        final Collection<E> nonDistinctElements = new ArrayList<>(); // keep actual's order for reporting mismatch

        for (final E element : actual) {
            if (!elements.add(element)) {
                nonDistinctElements.add(element);
            }
        }

        mismatchDescription.appendText(" non distinct elements are ").appendValueList("[", ", ", "]",
                nonDistinctElements);
    }
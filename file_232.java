  @Nonnull
  public static <E extends Comparable<? super E>> Set<E> ofIterable(final Iterable<E> elements) {
    if (elements instanceof Collection) {
      return ofCollection((Collection<E>) elements);
    }
    return ofSeqInternal(Seq.ofIterable(elements).distinct());
  }
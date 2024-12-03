  public static <T> List<T> randomListFrom(Iterable<T> elements, Range<Integer> size) {
    checkArgument(!isEmpty(elements), "Elements to populate from must not be empty");
    return randomListFrom(() -> IterableUtils.randomFrom(elements), size);
  }
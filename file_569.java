  public static <T, U> Function<T, U> memoize(final Function<T, U> function) {
    return new Memoizer<T, U>().doMemoize(function);
  }
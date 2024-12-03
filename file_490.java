  public static <T> T median(List<? extends T> data, Comparator<? super T> comparator) {
    return median(data, comparator, 0, data.size());
  }
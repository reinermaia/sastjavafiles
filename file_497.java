  @SuppressWarnings("unchecked")
  public static <T> T[] filter(T[] array, Filter<T> filter) {

    Assert.notNull(array, "Array is required");
    Assert.notNull(filter, "Filter is required");

    List<T> arrayList = stream(array).filter(filter::accept).collect(Collectors.toList());

    return arrayList.toArray((T[]) Array.newInstance(array.getClass().getComponentType(), arrayList.size()));
  }
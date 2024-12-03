  public <T> Observable<T> getAndObserve(String key, Class<T> classOfT, T defaultValue) {
    return getAndObserve(key, TypeToken.fromClass(classOfT), defaultValue);
  }
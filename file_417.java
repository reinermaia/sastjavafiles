  @Override @NonNull public Observable<ValueUpdate<T>> observe() {
    Observable<ValueUpdate<T>> startingValue = get()
        .map(new Function<T, ValueUpdate<T>>() {
          @Override public ValueUpdate<T> apply(T value) throws Exception {
            return new ValueUpdate<T>(value);
          }
        })
        .defaultIfEmpty(ValueUpdate.<T>empty())
        .toObservable();

    return updateSubject.startWith(startingValue);
  }
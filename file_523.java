  @SuppressWarnings("unchecked") // how to explain?
  @Override
  public <S extends T> Ordering<S> reverse() {
    return (Ordering<S>) forwardOrder;
  }
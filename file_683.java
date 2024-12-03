    public static <T> Observable<T> map(Observable<?> fromObservable, final T toValue) {
        if (fromObservable != null) {
            return fromObservable.subscribeOn(Schedulers.io())
                    .map(new RXMapper<T>(toValue));
        } else {
            return Observable.empty();
        }
    }
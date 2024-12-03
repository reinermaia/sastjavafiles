    public static <T> Observable<T> fromObservableValue(final ObservableValue<T> fxObservable) {
        return Observable.create((ObservableEmitter<T> emitter) -> {
            if (fxObservable.getValue() != null)
                emitter.onNext(fxObservable.getValue());

            final ChangeListener<T> listener = (observableValue, prev, current) -> {
                emitter.onNext(current);
            };

            fxObservable.addListener(listener);

            emitter.setDisposable(JavaFxSubscriptions.unsubscribeInEventDispatchThread(() -> fxObservable.removeListener(listener)));
        });
    }
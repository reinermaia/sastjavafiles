    @Override
    public Observable<Observable<Integer>> call(Observable<Observable<R>> observable) {
        return observable.map(new Func1<Observable<R>, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(Observable<R> parameters) {
                return builder.clearParameters().parameters(parameters).count();
            }
        });
    }
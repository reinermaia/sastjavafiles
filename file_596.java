    @Override
    public Observable<T> call(Observable<R> source) {
        if (operatorType == OperatorType.PARAMETER)
            return builder.parameters(source).get(function);
        else if (operatorType == OperatorType.DEPENDENCY)
            // dependency
            return builder.dependsOn(source).get(function);
        else // PARAMETER_LIST
        {
            @SuppressWarnings("unchecked")
            Observable<Observable<Object>> obs = (Observable<Observable<Object>>) source;
            return obs.concatMap(new Func1<Observable<Object>, Observable<T>>() {
                @Override
                public Observable<T> call(Observable<Object> parameters) {
                    return builder.parameters(parameters).get(function);
                }
            });
        }
    }
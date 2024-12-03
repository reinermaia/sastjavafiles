    public Tuple3<T1,T2,T3> memo(){
        Tuple3<T1,T2,T3> host = this;
        return new Tuple3<T1,T2,T3>(null,null, null){
            final Supplier<T1> memo1 = Memoize.memoizeSupplier(host::_1);
            final Supplier<T2> memo2 = Memoize.memoizeSupplier(host::_2);
            final Supplier<T3> memo3 = Memoize.memoizeSupplier(host::_3);
            @Override
            public T1 _1() {

                return memo1.get();
            }

            @Override
            public T2 _2() {
                return memo2.get();
            }
            @Override
            public T3 _3() {
                return memo3.get();
            }
        };
    }
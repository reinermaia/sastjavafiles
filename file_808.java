    public NDMatrix mul(double x, NDMatrix c) {
        A.muli(x, c.A);
        return c;
    }
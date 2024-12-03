    public Matrix multiply(double k)
    {
        double pv[][] = new double[nRows][nCols]; // product values

        // Compute values of the product.
        for (int r = 0; r < nRows; ++r) {
            for (int c = 0; c < nCols; ++c) {
                pv[r][c] = k*values[r][c];
            }
        }

        return new Matrix(pv);
    }
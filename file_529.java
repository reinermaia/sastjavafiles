    public Matrix multiply(Matrix m) throws MatrixException
    {
        // Validate m's dimensions.
        if (nCols != m.nRows) {
            throw new MatrixException(
                                MatrixException.INVALID_DIMENSIONS);
        }

        double pv[][] = new double[nRows][m.nCols];  // product values

        // Compute values of the product.
        for (int r = 0; r < nRows; ++r) {
            for (int c = 0; c < m.nCols; ++c) {
                double dot = 0;
                for (int k = 0; k < nCols; ++k) {
                    dot += values[r][k] * m.values[k][c];
                }
                pv[r][c] = dot;
            }
        }

        return new Matrix(pv);
    }
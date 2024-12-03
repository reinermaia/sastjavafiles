    public Matrix multiply(Matrix B)
    {
        Matrix C = new DenseMatrix(this.rows(), B.cols());
        multiply(B, C);
        return C;
    }
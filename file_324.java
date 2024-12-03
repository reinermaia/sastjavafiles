    public Matrix multiply(Matrix B, ExecutorService threadPool)
    {
        Matrix C = new DenseMatrix(this.rows(), B.cols());
        multiply(B, C, threadPool);
        return C;
    }
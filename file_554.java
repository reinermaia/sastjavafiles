    public Matrix multiply(Matrix C) {
        checkKhatriRao(C);

        for (int i = 0; i < A.numColumns(); ++i)
            for (int j = 0; j < A.numRows(); ++j)
                for (int k = 0; k < B.numRows(); ++k) {
                    double value = A.get(j, i) * B.get(k, i);
                    int destLine = B.numRows() * j + k;
                    C.add(destLine, i, value);
                }
        return C;

    }
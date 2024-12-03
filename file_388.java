    public Matrix2f mul(Matrix2f m) {
        return new Matrix2f(
                m00 * m.m00 + m01 * m.m10, m00 * m.m01 + m01 * m.m11,
                m10 * m.m00 + m11 * m.m10, m10 * m.m01 + m11 * m.m11);
    }
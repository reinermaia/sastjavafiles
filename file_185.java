  public Matrix multiply (final float k)
  {
    final float pv[][] = new float [m_nRows] [m_nCols]; // product values

    // Compute values of the product.
    for (int r = 0; r < m_nRows; ++r)
    {
      for (int c = 0; c < m_nCols; ++c)
      {
        pv[r][c] = k * m_aValues[r][c];
      }
    }

    return new Matrix (pv);
  }
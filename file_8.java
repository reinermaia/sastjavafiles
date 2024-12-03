  @Implementation
  protected void setScale(float sx, float sy) {
    setOps.put(SCALE, sx + " " + sy);
    simpleMatrix = SimpleMatrix.scale(sx, sy);
  }
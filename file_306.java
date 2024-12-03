  private int pickRandomSlotInR() {
    assert r_ > 0;
    final int offset = h_ + m_;
    if (r_ == 1) {
      return offset;
    } else {
      return offset + SamplingUtil.rand.nextInt(r_);
    }
  }
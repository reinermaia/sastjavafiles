  void exportToMemory(final WritableMemory wmem) {
    final Format format = getFormat();
    switch (format) {
      case EMPTY_MERGED : {
        putEmptyMerged(wmem, lgK, seedHash);
        break;
      }
      case EMPTY_HIP : {
        putEmptyHip(wmem, lgK, seedHash);
        break;
      }
      case SPARSE_HYBRID_MERGED : {
        putSparseHybridMerged(wmem,
            lgK,
            (int) numCoupons, //unsigned
            csvLengthInts,
            seedHash,
            csvStream);
        break;
      }
      case SPARSE_HYBRID_HIP : {
        putSparseHybridHip(wmem,
            lgK,
            (int) numCoupons, //unsigned
            csvLengthInts,
            kxp,
            hipEstAccum,
            seedHash,
            csvStream);
        break;
      }
      case PINNED_SLIDING_MERGED_NOSV : {
        putPinnedSlidingMergedNoSv(wmem,
            lgK,
            fiCol,
            (int) numCoupons, //unsigned
            cwLengthInts,
            seedHash,
            cwStream);
        break;
      }
      case PINNED_SLIDING_HIP_NOSV : {
        putPinnedSlidingHipNoSv(wmem,
            lgK,
            fiCol,
            (int) numCoupons, //unsigned
            cwLengthInts,
            kxp,
            hipEstAccum,
            seedHash,
            cwStream);
        break;
      }
      case PINNED_SLIDING_MERGED : {
        putPinnedSlidingMerged(wmem,
            lgK,
            fiCol,
            (int) numCoupons, //unsigned
            numCsv,
            csvLengthInts,
            cwLengthInts,
            seedHash,
            csvStream,
            cwStream);
        break;
      }
      case PINNED_SLIDING_HIP : {
        putPinnedSlidingHip(wmem,
            lgK,
            fiCol,
            (int) numCoupons, //unsigned
            numCsv,
            kxp,
            hipEstAccum,
            csvLengthInts,
            cwLengthInts,
            seedHash,
            csvStream,
            cwStream);
        break;
      }
    }
  }
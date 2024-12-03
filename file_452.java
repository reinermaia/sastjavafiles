  public static int[] activeColumns(DHistogram[] hist) {
    int[] cols = new int[hist.length];
    int len=0;
    for( int i=0; i<hist.length; i++ ) {
      if (hist[i]==null) continue;
      assert hist[i]._min < hist[i]._maxEx && hist[i].nbins() > 1 : "broken histo range "+ hist[i];
      cols[len++] = i;        // Gather active column
    }
//    cols = Arrays.copyOfRange(cols, len, hist.length);
    return cols;
  }
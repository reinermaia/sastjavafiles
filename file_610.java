  private static long toPgSecs(long secs) {
    // java epoc to postgres epoc
    secs -= 946684800L;

    // Julian/Greagorian calendar cutoff point
    if (secs < -13165977600L) { // October 15, 1582 -> October 4, 1582
      secs -= 86400 * 10;
      if (secs < -15773356800L) { // 1500-03-01 -> 1500-02-28
        int years = (int) ((secs + 15773356800L) / -3155823050L);
        years++;
        years -= years / 4;
        secs += years * 86400;
      }
    }

    return secs;
  }
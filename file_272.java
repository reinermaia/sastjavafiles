  private static long toJavaSecs(long secs) {
    // postgres epoc to java epoc
    secs += 946684800L;

    // Julian/Gregorian calendar cutoff point
    if (secs < -12219292800L) { // October 4, 1582 -> October 15, 1582
      secs += 86400 * 10;
      if (secs < -14825808000L) { // 1500-02-28 -> 1500-03-01
        int extraLeaps = (int) ((secs + 14825808000L) / 3155760000L);
        extraLeaps--;
        extraLeaps -= extraLeaps / 4;
        secs += extraLeaps * 86400L;
      }
    }
    return secs;
  }
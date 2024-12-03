  public void printTimeStatistics() {
    print("Elapsed time statistics:");

    List<String> timers = Lists.newArrayList(getAllTimers());
    Collections.sort(timers);
    for (String timer : timers) {
      double total = (double) getTimerElapsedTime(timer);
      long invocations = getTimerInvocations(timer);
      double average = total / invocations;
      print(String.format("%s: %.3f sec (%.3f ms * %d)", timer, (total / 1000), average, invocations));
    }
  }
  protected String currentProcessId() {
    String currentProcessId = getRuntimeMXBean().getName();

    if (isBlank(currentProcessId)) throw new IllegalStateException("Unable to extract current process ID.");

    int indexOfAtSymbol = currentProcessId.indexOf("@");

    if (indexOfAtSymbol > 0) currentProcessId = currentProcessId.substring(0, indexOfAtSymbol);

    return currentProcessId;
  }
  synchronized int size( int priority) {
    if (priority < 0 || priority >= LEVEL) {
      throw new IllegalArgumentException("Unsupported priority: " + priority);
    }
    return priorityQueues.get(priority).size();
  }
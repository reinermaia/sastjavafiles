  public Counter getCounter(String group, String name) {
    Map<String,Counter> groupCounters = getGroup(group);
    if (groupCounters != null) {
      return groupCounters.get(name);
    }

    return null;
  }
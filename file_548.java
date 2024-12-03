  private static List<String> sortedList(Set<String> set) {
    return set.stream().sorted().collect(Collectors.toList());
  }
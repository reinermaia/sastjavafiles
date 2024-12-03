  public Map<String, Integer> countUsersByGroups(DbSession session, Collection<Integer> groupIds) {
    Map<String, Integer> result = Maps.newHashMap();
    executeLargeInputs(
      groupIds,
      input -> {
        List<GroupUserCount> userCounts = mapper(session).countUsersByGroup(input);
        for (GroupUserCount count : userCounts) {
          result.put(count.groupName(), count.userCount());
        }
        return userCounts;
      });

    return result;
  }
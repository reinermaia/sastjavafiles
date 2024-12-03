  protected static String getGroup(final Matcher matcher, final int group)
  {
    final int groupCount = matcher.groupCount();
    if (groupCount > group - 1)
    {
      return matcher.group(group);
    }
    else
    {
      return null;
    }
  }
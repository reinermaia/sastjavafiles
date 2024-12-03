  public void setWorkingDirectory(Path dir) throws IOException {
    ensureState(JobState.DEFINE);
    conf.setWorkingDirectory(dir);
  }
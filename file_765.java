  public void setWorkingDirectory(Path dir) {
    if (!dir.isAbsolute()) {
      FileSystem.LogForCollect
          .info("set job working directory to non absolute path: " + dir
              + " working directory: " + getWorkingDirectory());
    }
    dir = new Path(getWorkingDirectory(), dir);
    set("mapred.working.dir", dir.toString());
  }
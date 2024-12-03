  @Override
  public void setWorkingDirectory(Path new_dir) {
    LOG.debug("set working directory: {}", new_dir.toString());
    storageClient.setWorkingDirectory(new_dir);
  }
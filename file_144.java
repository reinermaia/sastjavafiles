  private void unzipToWatchedFolder(File file) {
    log.info("Unzipping... " + file.getName());
    try {
      ZipUtils.unzip(file, new File(iosServerConfiguration.getAppFolderToMonitor()));
    } catch (IOException e) {
      log.warning("Problem unzipping " + file.getAbsolutePath() + ", " + e.toString());
    }
  }
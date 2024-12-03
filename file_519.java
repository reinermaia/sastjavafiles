  private int extractZip(ZipFile zipFile, File destFolder, Map<String, String> replaceTokens, Set<PathMatcher> extractMatchers, Set<PathMatcher> skipMatchers, Set<PathMatcher> filterMatchers, boolean overwrite, boolean writeMd5Sums) throws IOException {
    Enumeration<ZipArchiveEntry> en = zipFile.getEntries();
    int entries = 0;
    while (en.hasMoreElements()) {
      ZipArchiveEntry nextEntry = en.nextElement();
      extractEntry(zipFile.getInputStream(nextEntry), nextEntry, destFolder, replaceTokens, extractMatchers, skipMatchers, filterMatchers, overwrite, writeMd5Sums);
      entries++;
    }
    return entries;
  }
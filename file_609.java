  public static void replaceFile(String fileName, final Map<String, List<Replacer>> profiles, Charset charset)
      throws Exception, FileNotFoundException {
    File file = new File(fileName);
    if (file.isFile() && !file.isHidden()) {
      List<Replacer> replacers = profiles.get(Strings.substringAfterLast(fileName, "."));
      if (null == replacers) { return; }
      logger.info("processing {}", fileName);
      String filecontent = Files.readFileToString(file, charset);
      filecontent = Replacer.process(filecontent, replacers);
      writeToFile(filecontent, fileName, charset);
    } else {
      String[] subFiles = file.list(new FilenameFilter() {
        public boolean accept(File dir, String name) {
          if (dir.isDirectory()) return true;
          boolean matched = false;
          for (String key : profiles.keySet()) {
            matched = name.endsWith(key);
            if (matched) return true;
          }
          return false;
        }
      });
      if (null != subFiles) {
        for (int i = 0; i < subFiles.length; i++) {
          replaceFile(fileName + '/' + subFiles[i], profiles, charset);
        }
      }
    }
  }
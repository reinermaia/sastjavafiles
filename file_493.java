  protected String readFile(File file, List<String> lines) {
    int		i;

    try {
      lines.addAll(Files.readAllLines(file.toPath()));
      i = 0;
      while (i < lines.size()) {
        if (lines.get(i).trim().isEmpty()) {
          lines.remove(i);
          continue;
	}
	if (lines.get(i).startsWith("#")) {
          lines.remove(i);
          continue;
	}
	i++;
      }
    }
    catch (Exception e) {
      return "Failed to read file: " + file + "\n" + e;
    }

    return null;
  }
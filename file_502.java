  int restoreFile(String fileLocation) {
    int exitCode = 0;

    File file = new File(fileLocation);
    BufferedReader reader = null;
    FileWriter writer = null;
    try {
      reader = new BufferedReader(new FileReader(file));
      String fileLine;
      List<String> lines = new LinkedList<String>();

      while ((fileLine = reader.readLine()) != null) {
        if (fileLine.trim().startsWith(COMMENT)) {
          lines.add(fileLine.substring(COMMENT.length()));
          continue;
        } else if (fileLine.trim().endsWith(COMMENT)) {
          continue;
        }
        lines.add(fileLine);
      }

      writer = new FileWriter(file);
      for (String line : lines) {
        writer.write(line);
        writer.write("\n");
      }
    } catch (IOException ex) {
      exitCode = 1;
    } finally {
      try {
        if (reader != null) {
          reader.close();
        }
        if (writer != null) {
          writer.close();
        }
      } catch (IOException ioex) {
        // We did all we could to close
      }
    }

    return exitCode;
  }
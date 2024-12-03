  public void saveListTo(final String fileName) {
    try {
      PrintStream stream = new PrintStream(new File(fileName));
      printList(stream);
      stream.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
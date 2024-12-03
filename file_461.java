  public static boolean saveToFile(int type, Collection<?> list, File file) {
    BufferedWriter out = null;
    try {
      if (type == APPEND) {
        out = new BufferedWriter(new FileWriter(file, true));
      } else {
        out = new BufferedWriter(new FileWriter(file));
      }

      for (Object str : list) {
        out.write(str + CARRIAGE_RETURN);
      }
      out.close();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    } finally {
      try {
        if (out != null) {
          out.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
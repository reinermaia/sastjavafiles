  public Process getProcessById(String id) {
    for (Process process : processes) {
      if (process.getId().equals(id)) {
        return process;
      }
    }
    return null;
  }
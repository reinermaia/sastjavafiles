  public void switchReadOnlyConnection(Boolean mustBeReadOnly) throws SQLException {
    if (urlParser.getOptions().assureReadOnly && currentReadOnlyAsked != mustBeReadOnly) {
      proxy.lock.lock();
      try {
        // verify not updated now that hold lock, double check safe due to volatile
        if (currentReadOnlyAsked != mustBeReadOnly) {
          currentReadOnlyAsked = mustBeReadOnly;
          setSessionReadOnly(mustBeReadOnly, currentProtocol);
        }
      } finally {
        proxy.lock.unlock();
      }
    }
  }
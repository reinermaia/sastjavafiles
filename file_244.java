  private void setSocketTimeout(int millis) throws PSQLException {
    try {
      Socket s = pgStream.getSocket();
      if (!s.isClosed()) { // Is this check required?
        pgStream.getSocket().setSoTimeout(millis);
      }
    } catch (SocketException e) {
      throw new PSQLException(GT.tr("An error occurred while trying to reset the socket timeout."),
        PSQLState.CONNECTION_FAILURE, e);
    }
  }
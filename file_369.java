  private ByteBuffer recv(int attempt)
          throws IOException, SocketException, SocketTimeoutException {
    int timeout = UDP_BASE_TIMEOUT_SECONDS * (int) Math.pow(2, attempt);
    logger.trace("Setting receive timeout to {}s for attempt {}...",
            timeout, attempt);
    this.socket.setSoTimeout(timeout * 1000);

    try {
      DatagramPacket p = new DatagramPacket(
              new byte[UDP_PACKET_LENGTH],
              UDP_PACKET_LENGTH);
      this.socket.receive(p);
      return ByteBuffer.wrap(p.getData(), 0, p.getLength());
    } catch (SocketTimeoutException ste) {
      throw ste;
    }
  }
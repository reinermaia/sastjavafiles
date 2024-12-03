  public byte[] getHardwareAddress()
  {
    if (CurrentTime.isTest() || System.getProperty("test.mac") != null) {
      return new byte[] { 10, 0, 0, 0, 0, 10 };
    }
    
    for (NetworkInterfaceBase nic : getNetworkInterfaces()) {
      if (! nic.isLoopback()) {
        return nic.getHardwareAddress();
      }
    }
    
    try {
      InetAddress localHost = InetAddress.getLocalHost();
      
      return localHost.getAddress();
    } catch (Exception e) {
      log.log(Level.FINER, e.toString(), e);
    }
    
    return new byte[0];
  }
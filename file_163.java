    public static InetAddress getHostAddress() {
        InetAddress localAddress = null;
        try {
            localAddress = InetAddress.getLocalHost();
            if (isValidHostAddress(localAddress)) {
                return localAddress;
            }
        } catch (Throwable e) {
            logger.warn("Failed to retriving local host ip address, try scan network card ip address. cause: "
                        + e.getMessage());
        }
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            if (interfaces != null) {
                while (interfaces.hasMoreElements()) {
                    try {
                        NetworkInterface network = interfaces.nextElement();
                        Enumeration<InetAddress> addresses = network.getInetAddresses();
                        if (addresses != null) {
                            while (addresses.hasMoreElements()) {
                                try {
                                    InetAddress address = addresses.nextElement();
                                    if (isValidHostAddress(address)) {
                                        return address;
                                    }
                                } catch (Throwable e) {
                                    logger.warn("Failed to retriving network card ip address. cause:" + e.getMessage());
                                }
                            }
                        }
                    } catch (Throwable e) {
                        logger.warn("Failed to retriving network card ip address. cause:" + e.getMessage());
                    }
                }
            }
        } catch (Throwable e) {
            logger.warn("Failed to retriving network card ip address. cause:" + e.getMessage());
        }
        logger.error("Could not get local host ip address, will use 127.0.0.1 instead.");
        return localAddress;
    }
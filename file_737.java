    public InetAddress getIpAddress() throws UnknownHostException
    {
        byte[] ip = this.ipAddress;

        if (ip.length == 8 || ip.length == 32) {
            ip = new byte[ip.length / 2];
            System.arraycopy(this.ipAddress, 0, ip, 0, ip.length);
        }

        return InetAddress.getByAddress(ip);
    }
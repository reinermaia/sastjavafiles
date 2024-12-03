    @Override
    public String getName()
    {
        try {
            if (this.ipAddress.length != 8 && this.ipAddress.length != 32) {
                return getIpAddress().getHostAddress();
            }
            return getIpAddress().getHostAddress() + "/" + getIpMask().getHostAddress();
        } catch (UnknownHostException e) {
            return Arrays.toString(this.ipAddress);
        }
    }
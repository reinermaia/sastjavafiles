    public static IPAddressType getAddressType(String ipAddress)
    {
    	if(IPAddressUtil.isIPv4LiteralAddress(ipAddress))
    		return IPAddressType.IPV4;
    	
    	if(IPAddressUtil.isIPv6LiteralAddress(ipAddress))
    		return IPAddressType.IPV6;
    	
    	return IPAddressType.INVALID;
    }
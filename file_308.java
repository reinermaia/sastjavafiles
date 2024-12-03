	public static Socket setupSocket( Socket socket , int socketSendBufferSize , int socketRecvBufferSize ) throws PacketTransportException
    {
    	try
    	{
	    	socket.setTcpNoDelay(true);    	
	    	socket.setSendBufferSize(socketSendBufferSize);
	    	socket.setReceiveBufferSize(socketRecvBufferSize);
	    	socket.setKeepAlive(false);
	    	
	    	return socket;
    	}
    	catch (SocketException e)
    	{
    		throw new PacketTransportException("Could not set socket options",e);
    	}
    }
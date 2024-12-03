	private int configureSocketTimeout(int timeout) {

		if (provider instanceof SocketTimeoutSupport) {
			try {
				SocketTimeoutSupport sock = (SocketTimeoutSupport) provider;
				int ret = sock.getSoTimeout();
				sock.setSoTimeout(timeout);
				return ret;
			} catch (IOException ex) {
			}
		}

		return 0;
	}
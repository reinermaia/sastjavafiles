	private void readConfig() throws KNXException
	{
		final List config = new ArrayList();
		int pid = PropertyClient.PID.KNX_INDIVIDUAL_ADDRESS;
		byte[] data = query(pid);
		if (data != null)
			add(config, pid, "KNXnet/IP server", new IndividualAddress(data).toString());
		add(config, PropertyClient.PID.FRIENDLY_NAME, "name", queryFriendlyName());

		pid = PropertyClient.PID.IP_CAPABILITIES;
		if ((data = query(pid)) != null)
			add(config, pid, "IP address assignment available",
				getIPAssignment(new byte[] { (byte) (data[0] << 1 | 0x01) }));

		pid = PropertyClient.PID.IP_ASSIGNMENT_METHOD;
		if ((data = query(pid)) != null)
			add(config, pid, "IP address assignment enabled", getIPAssignment(data));

		pid = PropertyClient.PID.CURRENT_IP_ASSIGNMENT_METHOD;
		if ((data = query(pid)) != null)
			add(config, pid, "IP address assignment current", getIPAssignment(data));

		pid = PropertyClient.PID.KNXNETIP_ROUTING_CAPABILITIES;
		if ((data = query(pid)) != null)
			add(config, pid, "routing capabilities", getRoutingCaps(data));

		addIP(config, PropertyClient.PID.IP_ADDRESS, "IP address configured");
		addIP(config, PropertyClient.PID.CURRENT_IP_ADDRESS, "IP address current");
		addIP(config, PropertyClient.PID.SUBNET_MASK, "subnet mask configured");
		addIP(config, PropertyClient.PID.CURRENT_SUBNET_MASK, "subnet mask  current");
		addIP(config, PropertyClient.PID.DEFAULT_GATEWAY, "default gateway configured");
		addIP(config, PropertyClient.PID.CURRENT_DEFAULT_GATEWAY,
			"default gateway current");
		addIP(config, PropertyClient.PID.DHCP_BOOTP_SERVER, "DHCP/BootP server");
		addIP(config, PropertyClient.PID.ROUTING_MULTICAST_ADDRESS, "routing multicast");

		receivedConfig(config);
	}
    public void sendOneWay(MessageOut message, int id, InetAddress to)
    {
        if (logger.isTraceEnabled())
            logger.trace(FBUtilities.getBroadcastAddress() + " sending " + message.verb + " to " + id + "@" + to);

        if (to.equals(FBUtilities.getBroadcastAddress()))
            logger.trace("Message-to-self {} going over MessagingService", message);

        // message sinks are a testing hook
        MessageOut processedMessage = SinkManager.processOutboundMessage(message, id, to);
        if (processedMessage == null)
        {
            return;
        }

        // get pooled connection (really, connection queue)
        OutboundTcpConnection connection = getConnection(to, processedMessage);

        // write it
        connection.enqueue(processedMessage, id);
    }
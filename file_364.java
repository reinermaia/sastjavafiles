  public void send(Queue queue, Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
    if (TraceComponent.isAnyTracingEnabled() && tc.isEntryEnabled()) SibTr.entry(this, tc, "send", new Object[]{queue, message, deliveryMode, priority, timeToLive});
    super.send(queue, message, deliveryMode, priority, timeToLive);
    if (TraceComponent.isAnyTracingEnabled() && tc.isEntryEnabled()) SibTr.exit(this, tc, "send");
  }
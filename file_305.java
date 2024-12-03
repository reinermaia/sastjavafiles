    @Override
	public final void setPriority(int priority) throws JMSException
    {
        if (priority < 0 || priority > 9)
            throw new FFMQException("Invalid priority value : "+priority,"INVALID_PRIORITY");
        
        this.defaultPriority = priority;
    }
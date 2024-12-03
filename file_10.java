	private void setHiddens(ITerminalConsumer... hiddenConsumers) {
		for(ITerminalConsumer hidden: this.hiddens)
			hidden.setHidden(false);
		this.hiddens = hiddenConsumers;
		for(ITerminalConsumer hidden: this.hiddens)
			hidden.setHidden(true);
	}
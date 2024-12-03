	public Order startInstanceByExecution(Execution execution) {
		Process process = execution.getProcess();
		StartModel start = process.getModel().getStart();
		AssertHelper.notNull(start, "流程定义[id=" + process.getId() + "]没有开始节点");
		
		Execution current = execute(process, execution.getOperator(), execution.getArgs(), 
				execution.getParentOrder().getId(), execution.getParentNodeName());
		start.execute(current);
		return current.getOrder();
	}
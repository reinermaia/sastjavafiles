	private ProcessDiagram buildDiagramByProcessInstanceId(Long processInstanceId) {
		ProcessInstance pi = processService.getProcessInstanceById(processInstanceId);
		long processId=0,rootId=0;
		if (pi != null) {
			processId=pi.getProcessId();
			rootId=pi.getRootId();
		}else{
			HistoryProcessInstance hpi=historyService.getHistoryProcessInstance(processInstanceId); 
			if(hpi!=null){
				processId=hpi.getProcessId();
				rootId=hpi.getProcessInstanceId();
			}else{
				throw new IllegalArgumentException("ProcessInstance " + processInstanceId + " is not exist!");				
			}
		}
		ProcessDefinition pd = processService.getProcessById(processId);
		ProcessDiagram diagram = pd.getDiagram();
		try {
			diagram = (ProcessDiagram)diagram.clone();
			resetProcessDiagramDefaultStyle(diagram);
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
		rebuildProcessDiagram(diagram,rootId);
		return diagram;
	}
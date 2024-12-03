    private Process getProcessInstanceDefinition0(Long processId, Long processInstDefId) {
        Process procdef = getProcess0(processId);
        if (procdef != null) {
            try {
                Document instanceDoc = getWorkflowDao().getDocument(processInstDefId);
                Process process = (Process) instanceDoc.getObject(Jsonable.class.getName(), null);
                process.setName(procdef.getName());
                process.setPackageName(procdef.getPackageName());
                return process;
            } catch (DataAccessException ex) {
                logger.severeException("Error retrieving instance document", ex);
            }
        }
        return null;
    }
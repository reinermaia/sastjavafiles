    public Long waitForProcess() throws InterruptedException {
        Long processId = waitProcessIds.peek();
        if (logger.isDebugEnabled()) {
            logger.debug("## {} get termin id [{}]", getPipelineId(), processId);
        }
        return processId;
    }
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected Object transform(Object result, QueryResultMapper resultMapper) {
        Object actualResult = null;
        if (result instanceof Collection) {

            if (ProcessInstanceCustomDesc.class.isAssignableFrom(resultMapper.getType())) {

                logger.debug("Converting collection of ProcessInstanceCustomDesc to ProcessInstanceCustomList");
                actualResult = convertToProcessInstanceCustomVarsList((Collection<ProcessInstanceCustomDesc>) result);
            } else if (ProcessInstanceWithVarsDesc.class.isAssignableFrom(resultMapper.getType())) {

                logger.debug("Converting collection of ProcessInstanceWithVarsDesc to ProcessInstanceList");
                actualResult = convertToProcessInstanceWithVarsList((Collection<ProcessInstanceWithVarsDesc>) result);
            } else if (ProcessInstanceDesc.class.isAssignableFrom(resultMapper.getType())) {

                logger.debug("Converting collection of ProcessInstanceDesc to ProcessInstanceList");
                actualResult = convertToProcessInstanceList((Collection<ProcessInstanceDesc>) result);
            } else if (UserTaskInstanceWithVarsDesc.class.isAssignableFrom(resultMapper.getType())) {

                logger.debug("Converting collection of UserTaskInstanceWithVarsDesc to TaskInstanceList");
                actualResult = convertToTaskInstanceWithVarsList((Collection<UserTaskInstanceWithVarsDesc>) result);
            } else if (UserTaskInstanceWithPotOwnerDesc.class.isAssignableFrom(resultMapper.getType())) {

                logger.debug("Converting collection of UserTaskInstanceWithPotOwnerDesc to TaskInstanceList");
                actualResult = convertToTaskInstanceListPO((Collection<UserTaskInstanceWithPotOwnerDesc>) result);
            } else if (UserTaskInstanceDesc.class.isAssignableFrom(resultMapper.getType())) {

                logger.debug("Converting collection of UserTaskInstanceDesc to TaskInstanceList");
                actualResult = convertToTaskInstanceList((Collection<UserTaskInstanceDesc>) result);
            } else if (TaskSummary.class.isAssignableFrom(resultMapper.getType())) {

                logger.debug("Converting collection of TaskSummary to TaskSummaryList");
                actualResult = convertToTaskSummaryList((Collection<TaskSummary>) result);
            } else if (ExecutionError.class.isAssignableFrom(resultMapper.getType())) {

                logger.debug("Converting collection of ExecutionError to ErrorInstanceList");
                actualResult = convertToErrorInstanceList((List<ExecutionError>) result);
            } else if (List.class.isAssignableFrom(resultMapper.getType())) {

                logger.debug("Converting collection of List to ArrayList");
                actualResult = new ArrayList((Collection) result);
            }else {

                logger.debug("Convert not supported for custom type {}", resultMapper.getType());
                actualResult = result;
            }

            logger.debug("Actual result after converting is {}", actualResult);
        } else {
            logger.debug("Result is not a collection - {}, skipping any conversion", result);
            actualResult = result;
        }
        return actualResult;
    }
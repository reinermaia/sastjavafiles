    private String getProcessId(OptionsAndArgs pOpts) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        if (pOpts.getPid() != null) {
            return pOpts.getPid();
        } else if (pOpts.getProcessPattern() != null) {
            return findProcess(pOpts.getProcessPattern()).getId();
        } else {
            throw new IllegalArgumentException("No process ID and no process name pattern given");
        }
    }
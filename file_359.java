    protected int getCurrentProcessID() throws ProcessHandlerException {
        int pid;
        // Not ideal but using JNA failed on RHEL5.
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        Field jvm = null;
        try {
            jvm = runtime.getClass().getDeclaredField("jvm");
            jvm.setAccessible(true);
            VMManagement mgmt = (VMManagement) jvm.get(runtime);
            Method pid_method = mgmt.getClass().getDeclaredMethod("getProcessId");
            pid_method.setAccessible(true);
            pid = (Integer) pid_method.invoke(mgmt);
        } catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new ProcessHandlerException(e);
        }
        return pid;
    }
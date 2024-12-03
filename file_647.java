    public void init() {
        re.put("pid", Lang.JdkTool.getProcessId("-1"));
        re.put("version", Lang.JdkTool.getMajorVersion());
        re.put("cores", Runtime.getRuntime().availableProcessors());
        updateMonitors();
    }
    public static File getExecutionPath() throws OSException {
        try {
            return new File(OSUtils.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
        } catch (URISyntaxException ex) {
            throw new OSException(ex);
        }
    }
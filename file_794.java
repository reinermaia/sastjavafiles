    private Properties readPropertyFile(String file) throws IOException {
        String fileName = file.startsWith("/") ? file : "/" + file;
        LOGGER.info("Reading properties from: " + fileName + ". Will try classpath, then file system.");
        return Util.readProperties(fileName);
    }
    private void readPropertiesFiles() {

        if (this.messageFileWildcard.isEmpty() || !CoreParameters.LOG_RESOLUTION.get()) {
            // Skip configuration loading
            LOGGER.info(JRebirthMarkers.MESSAGE, "Messages Loading is skipped");

        } else {
            // Assemble the regex pattern
            final Pattern filePattern = Pattern.compile(this.messageFileWildcard + "\\.properties");

            // Retrieve all resources from default classpath
            final Collection<String> list = ClasspathUtility.getClasspathResources(filePattern);

            LOGGER.info(JRebirthMarkers.MESSAGE, "{} Messages file{} found.", list.size(), list.size() > 1 ? "s" : "");

            for (final String rbFilename : list) {
                readPropertiesFile(rbFilename);
            }
        }
    }
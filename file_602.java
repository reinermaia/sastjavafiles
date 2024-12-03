	private void readPropertyFile(String propFile) {
		File file = null;
		if(propFile != null && !propFile.isEmpty()) {
			file = new File(propFile);
		}
		if(file == null || !file.exists()) {
			file = new File(CloudConductorPropertyProvider.CLOUDCONDUCTOR_PROP_FILE_DEFAULT_PATH);
		}
		if(file.exists()) {
			try(InputStream reader = new FileInputStream(file)) {
				Properties prop = new Properties();
				prop.load(reader);
				if(this.server == null && prop.containsKey(CloudConductorPropertyProvider.CLOUDCONDUCTOR_URL)) {
					this.server = prop.getProperty(CloudConductorPropertyProvider.CLOUDCONDUCTOR_URL);
				}
				if(this.template == null && prop.containsKey(CloudConductorPropertyProvider.TEMPLATE_NAME)) {
					this.template = prop.getProperty(CloudConductorPropertyProvider.TEMPLATE_NAME);
				}
				if(this.jwt == null && prop.containsKey(CloudConductorPropertyProvider.CLOUDCONDUCTOR_PROP_FILE_TOKEN)) {
					this.jwt = this.getAuthToken(prop.getProperty(CloudConductorPropertyProvider.CLOUDCONDUCTOR_PROP_FILE_TOKEN));
				}
			} catch(IOException ex) {
				this.logger.warn("Failed to find cloudconductor properties file: '{}'", file);
			}
		}
	}
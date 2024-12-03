	public void setWorkingDirectory(File workingDir) {
		Assert.notNull(workingDir, "workingDir cannot be null");

		logger.info("Setting working directory for LDAP_PROVIDER: "
				+ workingDir.getAbsolutePath());

		if (workingDir.exists()) {
			throw new IllegalArgumentException(
					"The specified working directory '"
							+ workingDir.getAbsolutePath()
							+ "' already exists. Another directory service instance may be using it or it may be from a "
							+ " previous unclean shutdown. Please confirm and delete it or configure a different "
							+ "working directory");
		}

		this.workingDir = workingDir;

		service.setWorkingDirectory(workingDir);
	}
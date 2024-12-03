	private File extractFile(String fileName, JarFile containingJar, File dstDir)
			throws DeploymentException {

		ZipEntry zipFileEntry = containingJar.getEntry(fileName);
		logger.trace("Extracting file " + fileName + " from "
				+ containingJar.getName());
		if (zipFileEntry == null) {
			throw new DeploymentException("Error extracting jar file  "
					+ fileName + " from " + containingJar.getName());
		}
		File extractedFile = new File(dstDir, new File(zipFileEntry.getName())
				.getName());
		try {
			pipeStream(containingJar.getInputStream(zipFileEntry),
					new FileOutputStream(extractedFile));
		} catch (FileNotFoundException e) {
			throw new DeploymentException("file " + fileName + " not found in "
					+ containingJar.getName(), e);
		} catch (IOException e) {
			throw new DeploymentException("erro extracting file " + fileName
					+ " from " + containingJar.getName(), e);
		}
		logger.debug("Extracted file " + extractedFile.getName());
		return extractedFile;
	}
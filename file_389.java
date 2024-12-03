	public static void extractZip(File zip, File toDir) throws IOException{
		if(!toDir.exists()) {
			throw new IOException("Directory '" + toDir + "' does not exist.");
		}

		try (ZipFile zipFile = new ZipFile(zip)) {
			Enumeration<? extends ZipEntry> entries = zipFile.entries();

			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();

				File target = new File(toDir, entry.getName());
				if (entry.isDirectory()) {
					// Assume directories are stored parents first then children.
					//logger.info("Extracting directory: " + entry.getName());
					// This is not robust, just for demonstration purposes.
					if(!target.mkdirs()) {
						logger.warning("Could not create directory " + target);
					}
					continue;
				}

				// zips can contain nested files in sub-dirs without separate entries for the directories
				if(!target.getParentFile().exists() && !target.getParentFile().mkdirs()) {
					logger.warning("Could not create directory " + target.getParentFile());
				}

				//logger.info("Extracting file: " + entry.getName());
				try (InputStream inputStream = zipFile.getInputStream(entry)) {
					try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(target))) {
						IOUtils.copy(inputStream, outputStream);
					}
				}
			}
		} catch (FileNotFoundException | NoSuchFileException e) {
			throw e;
		} catch (IOException e) {
			throw new IOException("While extracting file " + zip + " to " + toDir, e);
		}
	}
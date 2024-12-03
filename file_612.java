	public static void extractZip(InputStream zip, final File toDir) throws IOException{
		if(!toDir.exists()) {
			throw new IOException("Directory '" + toDir + "' does not exist.");
		}

		// Use the ZipFileVisitor to walk all the entries in the Zip-Stream and create
		// directories and files accordingly
		new ZipFileVisitor() {
			@Override
			public void visit(ZipEntry entry, InputStream data) throws IOException {
				File target = new File(toDir, entry.getName());
				if (entry.isDirectory()) {
					// Assume directories are stored parents first then children.
					//logger.info("Extracting directory: " + entry.getName() + " to " + target);
					// This is not robust, just for demonstration purposes.
					if(!target.mkdirs()) {
						logger.warning("Could not create directory " + target);
					}
					return;
				}

				// zips can contain nested files in sub-dirs without separate entries for the directories
				if(!target.getParentFile().exists() && !target.getParentFile().mkdirs()) {
					logger.warning("Could not create directory " + target.getParentFile());
				}

				// it seems we cannot use IOUtils/FileUtils to copy as they close the stream
				int size;
				byte[] buffer = new byte[2048];
				try (OutputStream fout = new BufferedOutputStream(new FileOutputStream(target), buffer.length)) {
	                while ((size = data.read(buffer, 0, buffer.length)) != -1) {
	                    fout.write(buffer, 0, size);
	                }
				}
			}
		}.walk(zip);
	}
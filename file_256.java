	public final void fileCopy(File in, File out) throws IOException {
		assert in != null;
		assert out != null;
		getLog().debug("Copying file: " + in.toString() + " into " + out.toString()); //$NON-NLS-1$ //$NON-NLS-2$
		try (FileInputStream fis = new FileInputStream(in)) {
			try (FileChannel inChannel = fis.getChannel()) {
				try (FileOutputStream fos = new FileOutputStream(out)) {
					try (FileChannel outChannel = fos.getChannel()) {
						inChannel.transferTo(0, inChannel.size(), outChannel);
					}
				}
			}
		} finally {
			getBuildContext().refresh(out);
		}
	}
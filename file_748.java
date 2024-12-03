	public static void copy(Path sourcePath, Path targetPath, boolean executable) throws IOException {
		// we unwrap the file system to get raw streams without safety net
		FileSystem sFS = FileSystem.getUnguardedFileSystem(sourcePath.toUri());
		FileSystem tFS = FileSystem.getUnguardedFileSystem(targetPath.toUri());
		if (!tFS.exists(targetPath)) {
			if (sFS.getFileStatus(sourcePath).isDir()) {
				internalCopyDirectory(sourcePath, targetPath, executable, sFS, tFS);
			} else {
				internalCopyFile(sourcePath, targetPath, executable, sFS, tFS);
			}
		}
	}
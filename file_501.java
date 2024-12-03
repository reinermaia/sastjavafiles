  private void compressFileContents(@Nonnull Compressor compressor, @Nonnull File file) {
    log.trace("Starting compressing contents of file={}", file);

    final File targetFile = findNewFile(file.getAbsolutePath(), compressedFileSuffix);
    final File tempFile = findNewFile(file.getAbsolutePath(), tempCompressedFileSuffix);

    // compress source file contents and write result to the temp file
    try (final InputStream sourceStream = new FileInputStream(file)) {
      try (final OutputStream tempFileStream = new FileOutputStream(tempFile)) {
        try (final OutputStream compressionStream = compressor.openOutputStream(tempFileStream, file.getName())) {
          final byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];

          for (;;) {
            int read = sourceStream.read(buffer);
            if (read < 0) {
              break;
            }

            compressionStream.write(buffer, 0, read);
          }
        }
      }
    } catch (IOException e) {
      log.error("Unable to compress {} to {}", file.getAbsolutePath(), tempFile.getAbsoluteFile(), e);

      // delete temp file
      if (tempFile.exists() && !tempFile.delete()) {
        log.error("Unable to remove temp file {}", tempFile.getAbsolutePath());
      }

      return;
    }

    if (!tempFile.renameTo(targetFile)) {
      log.error("Can't rename {} to {}", tempFile.getAbsolutePath(), targetFile.getAbsoluteFile());
      return;
    }

    // now remove old file
    if (!file.delete()) {
      log.error("Unable to remove uncompressed log file={}", file.getAbsolutePath());
    }

    // rename succeeded
    log.trace("Compressed log file has been successfully created: {}", targetFile);
  }
  public static InputStream decompress(final InputStream in, final String fileName) throws IOException
  {
    if (fileName.endsWith(GZ_SUFFIX)) {
      return gzipInputStream(in);
    } else if (fileName.endsWith(BZ2_SUFFIX)) {
      return new BZip2CompressorInputStream(in, true);
    } else if (fileName.endsWith(XZ_SUFFIX)) {
      return new XZCompressorInputStream(in, true);
    } else if (fileName.endsWith(SNAPPY_SUFFIX)) {
      return new FramedSnappyCompressorInputStream(in);
    } else if (fileName.endsWith(ZSTD_SUFFIX)) {
      return new ZstdCompressorInputStream(in);
    } else if (fileName.endsWith(ZIP_SUFFIX)) {
      // This reads the first file in the archive.
      final ZipInputStream zipIn = new ZipInputStream(in, StandardCharsets.UTF_8);
      try {
        final ZipEntry nextEntry = zipIn.getNextEntry();
        if (nextEntry == null) {
          zipIn.close();

          // No files in the archive - return an empty stream.
          return new ByteArrayInputStream(new byte[0]);
        }
        return zipIn;
      }
      catch (IOException e) {
        try {
          zipIn.close();
        }
        catch (IOException e2) {
          e.addSuppressed(e2);
        }
        throw e;
      }
    } else {
      return in;
    }
  }
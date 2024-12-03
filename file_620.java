  public static void zipCompress(String filename) throws IOException {
    FileOutputStream fos = new FileOutputStream(filename + COMPRESSION_SUFFIX);
    CheckedOutputStream csum = new CheckedOutputStream(fos, new CRC32());
    ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(csum));
    out.setComment("Failmon records.");

    BufferedReader in = new BufferedReader(new FileReader(filename));
    out.putNextEntry(new ZipEntry(new File(filename).getName()));
    int c;
    while ((c = in.read()) != -1)
      out.write(c);
    in.close();

    out.finish();
    out.close();
  }
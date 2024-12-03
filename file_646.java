  private List<File> unzipCorpus(File outDir, ZipFile zip)
  {
    List<File> rootDirs = new ArrayList<>();

    Enumeration<? extends ZipEntry> zipEnum = zip.entries();
    while (zipEnum.hasMoreElements())
    {
      ZipEntry e = zipEnum.nextElement();
      File outFile = new File(outDir, e.getName().replaceAll("\\/", "/"));

      if (e.isDirectory())
      {
        if (!outFile.mkdirs())
        {
          log.warn("Could not create output directory " + outFile.
            getAbsolutePath());
        }
      } // end if directory
      else
      {
        if ("corpus.tab".equals(outFile.getName()) || "corpus.annis".equals(
          outFile.getName()))
        {
          rootDirs.add(outFile.getParentFile());
        }

        if (!outFile.getParentFile().isDirectory())
        {
          if (!outFile.getParentFile().mkdirs())
          {
            {
              log.warn(
                "Could not create output directory for file " + outFile.
                getAbsolutePath());
            }
          }
        }
        try (FileOutputStream outStream = new FileOutputStream(outFile);)
        {

          ByteStreams.copy(zip.getInputStream(e), outStream);
        }
        catch (FileNotFoundException ex)
        {
          log.error(null, ex);
        }
        catch (IOException ex)
        {
          log.error(null, ex);
        }
      } // end else is file
    } // end for each entry in zip file

    return rootDirs;
  }
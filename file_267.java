  @Nonnull
  private static ESuccess _copyFileViaChannel (@Nonnull final File aSrcFile, @Nonnull final File aDestFile)
  {
    final FileChannel aSrcChannel = FileChannelHelper.getFileReadChannel (aSrcFile);
    if (aSrcChannel == null)
      return ESuccess.FAILURE;

    try
    {
      final FileChannel aDstChannel = FileChannelHelper.getFileWriteChannel (aDestFile, EAppend.TRUNCATE);
      if (aDstChannel == null)
        return ESuccess.FAILURE;

      try
      {
        FileLock aSrcLock = null;
        FileLock aDestLock = null;
        try
        {
          final long nBytesToRead = aSrcChannel.size ();

          // Shared read lock and exclusive write lock
          aSrcLock = aSrcChannel.lock (0, nBytesToRead, true);
          aDestLock = aDstChannel.lock ();

          // Main copying - the loop version is much quicker than then
          // transferTo with full size!
          long nBytesWritten = 0;
          final long nChunkSize = 1L * CGlobal.BYTES_PER_MEGABYTE;
          while (nBytesWritten < nBytesToRead)
            nBytesWritten += aSrcChannel.transferTo (nBytesWritten, nChunkSize, aDstChannel);

          if (nBytesToRead != nBytesWritten)
          {
            if (LOGGER.isErrorEnabled ())
              LOGGER.error ("Failed to copy file. Meant to read " + nBytesToRead + " bytes but wrote " + nBytesWritten);
            return ESuccess.FAILURE;
          }
          return ESuccess.SUCCESS;
        }
        catch (final IOException ex)
        {
          throw new IllegalStateException ("Failed to copy from " + aSrcFile + " to " + aDestFile, ex);
        }
        finally
        {
          // Unlock
          ChannelHelper.release (aDestLock);
          ChannelHelper.release (aSrcLock);
        }
      }
      finally
      {
        ChannelHelper.close (aDstChannel);
      }
    }
    finally
    {
      ChannelHelper.close (aSrcChannel);
    }
  }
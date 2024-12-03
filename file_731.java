   @Override
   public void extractTo(DirectoryResource directoryResource)
   {
      try
      {
         getZipFile().extractAll(directoryResource.getFullyQualifiedName());
      }
      catch (ZipException e)
      {
         throw new ResourceException("Error while unzipping files", e);
      }
   }
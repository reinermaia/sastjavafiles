   public void setSimilarityClass(String className)
   {
      try
      {
         Class<?> similarityClass = ClassLoading.forName(className, this);
         similarity = (Similarity)similarityClass.newInstance();
      }
      catch (ClassNotFoundException e)
      {
         log.warn("Invalid Similarity class: " + className, e);
      }
      catch (InstantiationException e)
      {
         log.warn("Invalid Similarity class: " + className, e);
      }
      catch (IllegalAccessException e)
      {
         log.warn("Invalid Similarity class: " + className, e);
      }
   }
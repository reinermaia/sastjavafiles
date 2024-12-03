   public static String getStatusDescription(int status)
   {
      String description = "";

      Integer statusKey = new Integer(status);
      if (statusDescriptions.containsKey(statusKey))
      {
         description = statusDescriptions.get(statusKey);
      }

      return String.format("%s %d %s", WebDavConst.HTTPVER, status, description);
   }
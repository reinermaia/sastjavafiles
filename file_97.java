   public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
   {
      orderNumber = in.readInt();

      // read canonical file path
      int size = in.readInt();
      if (size > 0)
      {
         byte[] buf = new byte[size];
         in.readFully(buf);

         File f = new File(new String(buf, "UTF-8"));
         // validate if exists
         if (PrivilegedFileHelper.exists(f))
         {
            file = f;
         }
         else
         {
            file = null;
         }
      }
      else
      {
         // should not occurs but since we have a way to recover, it should not be
         // an issue
         file = null;
      }
   }
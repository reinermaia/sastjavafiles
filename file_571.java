  private String getTextLine( SearchLocation loc )
  {
    try( BufferedReader reader = PathUtil.createReader( getNode().getFile().getFileOrDir() ) )
    {
      for( int line = 0; line < loc._iLine; line++ )
      {
        String textLine = reader.readLine();
        if( line == loc._iLine-1 )
        {
          return textLine;
        }
      }
    }
    catch( Exception e )
    {
      throw new RuntimeException( e );
    }
    return "";
  }
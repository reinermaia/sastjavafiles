    private String multiLineString( String[] lines )
    {
        StringBuilder sb = new StringBuilder();
        if ( lines != null && lines.length > 0 )
        {
            sb.append( lines[0] );
            for ( int i = 1; i < lines.length; i++ )
            {
                sb.append( "\n" );
                sb.append( lines[i] );
            }
        }
        return sb.toString();
    }
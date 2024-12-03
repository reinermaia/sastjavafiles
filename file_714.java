    private CFile parseCFile( JSONObject jObj )
    {
        CFile cfile;

        if ( jObj.optBoolean( "is_dir", false ) ) {
            cfile = new CFolder( new CPath( jObj.getString( "path" ) ) );

        } else {
            cfile = new CBlob( new CPath( jObj.getString( "path" ) ), jObj.getLong( "bytes" ), jObj.getString( "mime_type" ) );
            String stringDate = jObj.getString( "modified" );

            try {
                // stringDate looks like: "Fri, 07 Mar 2014 17:47:55 +0000"
                SimpleDateFormat sdf = new SimpleDateFormat( "EEE, dd MMM yyyy HH:mm:ss Z", Locale.US );
                Date modified = sdf.parse( stringDate );
                cfile.setModificationDate( modified );

            } catch ( ParseException ex ) {
                throw new CStorageException( "Can't parse date modified: " + stringDate + " (" + ex.getMessage() + ")", ex );
            }
        }

        return cfile;
    }
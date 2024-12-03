    public static File earlHtmlReport( String outputDir )
                    throws FileNotFoundException {

        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        String resourceDir = cl.getResource( "com/occamlab/te/earl/lib" ).getPath();
        String earlXsl = cl.getResource( "com/occamlab/te/earl_html_report.xsl" ).toString();

        File htmlOutput = new File( outputDir, "result" );
        htmlOutput.mkdir();
        LOGR.fine( "HTML output is written to directory " + htmlOutput );
        File earlResult = new File( outputDir, "earl-results.rdf" );

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer( new StreamSource( earlXsl ) );
            transformer.setParameter( "outputDir", htmlOutput );
            File indexHtml = new File( htmlOutput, "index.html" );
            indexHtml.createNewFile();
            FileOutputStream outputStream = new FileOutputStream( indexHtml );
            transformer.transform( new StreamSource( earlResult ), new StreamResult( outputStream ) );
            // Foritfy Mod: Close the outputStream releasing its resources
            outputStream.close();
            FileUtils.copyDirectory( new File( resourceDir ), htmlOutput );
        } catch ( Exception e ) {
            LOGR.log( Level.SEVERE, "Transformation of EARL to HTML failed.", e );
            throw new RuntimeException( e );
        }
        if ( !htmlOutput.exists() ) {
            throw new FileNotFoundException( "HTML results not found at " + htmlOutput.getAbsolutePath() );
        }
        return htmlOutput;
    }
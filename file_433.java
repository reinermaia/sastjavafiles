	@Override
	protected File writeFileContent(String fileContent) throws IOException {

		// Load the template
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = getClass().getResourceAsStream( "/fop.tpl" );
		Utils.copyStreamSafely( in, out );

		//Copy the header in outputDirectory
		InputStream h = getClass().getResourceAsStream( "/roboconf.jpg" );
		File imgFile = new File( this.outputDirectory, "header.jpg" );
		Utils.copyStream( h, imgFile );

		// Create the target directory
		File targetFile = new File( this.outputDirectory, "index.fo" );
		Utils.createDirectory( targetFile.getParentFile());

		// Write the main file
		String toWrite = out.toString( "UTF-8" )
				.replace( TITLE_MARKUP, this.applicationTemplate.getName())
				.replace( CONTENT_MARKUP, fileContent )
				.replace( "header.jpg", this.outputDirectory.getAbsolutePath() + "/header.jpg" )
				.replace( "png/", this.outputDirectory.getAbsolutePath() + "/png/" )
				.replaceAll( "\n{3,}", "\n\n" );

		Utils.writeStringInto( toWrite, targetFile );
		return targetFile;
	}
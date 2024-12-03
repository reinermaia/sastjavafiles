    private void actionRead(boolean binary) throws ZipException, IOException, PageException {
	required("file", file, true);
	required("variable", variable);
	required("entrypath", entryPaths);
	ZipFile zip = getZip(file);

	if (entryPaths.length > 1) throw new ApplicationException("you can only read one entry!");

	try {
	    ZipEntry ze = getZipEntry(zip, entryPaths[0]);
	    if (ze == null) {
		String msg = ExceptionUtil.similarKeyMessage(names(zip), entryPaths[0], "entry", "zip file", "in the zip file [" + file + "]", true);
		throw new ApplicationException(msg);
		// throw new ApplicationException("zip file ["+file+"] has no entry with name ["+entryPath+"]");
	    }

	    ByteArrayOutputStream baos = new ByteArrayOutputStream();

	    InputStream is = zip.getInputStream(ze);
	    IOUtil.copy(is, baos, true, false);
	    zip.close();

	    if (binary) pageContext.setVariable(variable, baos.toByteArray());
	    else {
		if (charset == null) charset = ((PageContextImpl) pageContext).getResourceCharset().name();
		pageContext.setVariable(variable, new String(baos.toByteArray(), charset));
	    }
	}
	finally {
	    IOUtil.closeEL(zip);
	}

    }
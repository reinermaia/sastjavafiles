  private synchronized void readProperties() {
    try {
      propertyFileURI = CatalogManager.class.getResource("/"+propertyFile);
      InputStream in =
	CatalogManager.class.getResourceAsStream("/"+propertyFile);
      if (in==null) {
	if (!ignoreMissingProperties) {
	  System.err.println("Cannot find "+propertyFile);
	  // there's no reason to give this warning more than once
	  ignoreMissingProperties = true;
	}
	return;
      }
      resources = new PropertyResourceBundle(in);
    } catch (MissingResourceException mre) {
      if (!ignoreMissingProperties) {
	System.err.println("Cannot read "+propertyFile);
      }
    } catch (java.io.IOException e) {
      if (!ignoreMissingProperties) {
	System.err.println("Failure trying to read "+propertyFile);
      }
    }

    // This is a bit of a hack. After we've successfully read the properties,
    // use them to set the default debug level, if the user hasn't already set
    // the default debug level.
    if (verbosity == null) {
      try {
	String verbStr = resources.getString("verbosity");
	int verb = Integer.parseInt(verbStr.trim());
	debug.setDebug(verb);
	verbosity = new Integer(verb);
      } catch (Exception e) {
	// nop
      }
    }
  }
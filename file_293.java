	@Override
	public void setLegendImageServiceUrl(String legendImageServiceUrlAsString) {
		this.image = null; // remove the cached image
		this.legendImageServiceUrl = null; // Clear the cached value

		URL absoluteUrl = null;

		if (!legendImageServiceUrlAsString.startsWith("http:") && !legendImageServiceUrlAsString.startsWith("https:")) {

			try {
				String baseUrlAsString = dispatcherUrlService.getLocalDispatcherUrl();
				log.debug("BaseURL: {}", baseUrlAsString);
				URL baseUrl = new URL(baseUrlAsString);
				absoluteUrl = new URL(baseUrl, "../" + legendImageServiceUrlAsString);
				log.debug("AbsoluteUrl: {}", absoluteUrl);
			} catch (MalformedURLException e) {
				// Should never happen...
				log.error("Error converting URL " + legendImageServiceUrlAsString + " to absolute URL", e);
				e.printStackTrace();
			}
		} else {
			try {
				absoluteUrl = new URL(legendImageServiceUrlAsString);
			} catch (MalformedURLException e) {
				// Should never happen...
				log.error("Error converting URL " + legendImageServiceUrlAsString + " to absolute URL", e);
			}
		}
		this.legendImageServiceUrlAsString = absoluteUrl.toExternalForm();
	}
	private String convertPageToPdf (Pdf pdf, ByteArrayOutputStream baos) {
		try {
			baos.write(pdf.getPDF());
			return baos.toString("ISO-8859-1");
		} catch (IOException e) {

			logger.warn("pdf(): IOException", e);

		} catch (InterruptedException e) {

			logger.warn("pdf(): InterruptedException", e);

		}
		return "";
	}
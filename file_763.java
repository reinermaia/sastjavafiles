	public static void main( String args[] ) {
		// load and convert the image into a usable format
		BufferedImage image = UtilImageIO.loadImage(UtilIO.pathExample("particles01.jpg"));

		// convert into a usable format
		GrayF32 input = ConvertBufferedImage.convertFromSingle(image, null, GrayF32.class);
		GrayU8 binary = new GrayU8(input.width,input.height);
		GrayS32 label = new GrayS32(input.width,input.height);

		// Select a global threshold using Otsu's method.
		double threshold = GThresholdImageOps.computeOtsu(input, 0, 255);

		// Apply the threshold to create a binary image
		ThresholdImageOps.threshold(input,binary,(float)threshold,true);

		// remove small blobs through erosion and dilation
		// The null in the input indicates that it should internally declare the work image it needs
		// this is less efficient, but easier to code.
		GrayU8 filtered = BinaryImageOps.erode8(binary, 1, null);
		filtered = BinaryImageOps.dilate8(filtered, 1, null);

		// Detect blobs inside the image using an 8-connect rule
		List<Contour> contours = BinaryImageOps.contour(filtered, ConnectRule.EIGHT, label);

		// colors of contours
		int colorExternal = 0xFFFFFF;
		int colorInternal = 0xFF2020;

		// display the results
		BufferedImage visualBinary = VisualizeBinaryData.renderBinary(binary, false, null);
		BufferedImage visualFiltered = VisualizeBinaryData.renderBinary(filtered, false, null);
		BufferedImage visualLabel = VisualizeBinaryData.renderLabeledBG(label, contours.size(), null);
		BufferedImage visualContour = VisualizeBinaryData.renderContours(contours, colorExternal, colorInternal,
				input.width, input.height, null);

		ListDisplayPanel panel = new ListDisplayPanel();
		panel.addImage(visualBinary, "Binary Original");
		panel.addImage(visualFiltered, "Binary Filtered");
		panel.addImage(visualLabel, "Labeled Blobs");
		panel.addImage(visualContour, "Contours");
		ShowImages.showWindow(panel,"Binary Operations",true);
	}
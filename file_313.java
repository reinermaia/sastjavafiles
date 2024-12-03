    public static File convertPdf2Tiff(File inputPdfFile) throws IOException {
        if (PDFBOX.equals(System.getProperty(PDF_LIBRARY))) {
            return PdfBoxUtilities.convertPdf2Tiff(inputPdfFile);
        } else {
            try {
                return PdfGsUtilities.convertPdf2Tiff(inputPdfFile);
            } catch (Exception e) {
                System.setProperty(PDF_LIBRARY, PDFBOX);
                return convertPdf2Tiff(inputPdfFile);
            }
        }
    }
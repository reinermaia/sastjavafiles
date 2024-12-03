    private void generatePdf() {
        File pdfFile = new File(directory, filename + ".pdf");
        try (OutputStream os = new FileOutputStream(pdfFile)) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withHtmlContent(getHtmlForPDFConversion(), "file://" + pdfFile.getAbsolutePath()
                    .replaceAll(" ", "%20"));
            builder.toStream(os);
            builder.run();
        } catch (Exception e) {
            log.error(e);
        }
    }
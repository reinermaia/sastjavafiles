    public byte[] render(String html) throws RenderException {
        try {
            log.debug("Start rendering pdf from html with size of " + html.length());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfSaucerRenderer renderer = provider.getRenderer(html);

            log.debug("Renderer prepared");

            renderer.createPDF(baos);
            renderer.finishPDF();

            log.debug("pdf rendered");
            return baos.toByteArray();
        } catch (IOException|DocumentException e) {
            throw new RenderException("Cannot render pdf", e, "pdf");
        }
    }
    public ExportMatrix export(PCMContainer pcmContainer) {
        PCM pcm = pcmContainer.getPcm();

        final PCMMetadata metadata;
        if (pcmContainer.getMetadata() == null) {
            metadata = new PCMMetadata(pcm);
        } else {
            metadata = pcmContainer.getMetadata();
        }


        ExportMatrix matrix = new ExportMatrix();

        // Export name
        matrix.setName(pcm.getName());

        int productsStartRow = exportFeatures(metadata, matrix);

        exportProducts(pcm, metadata, matrix, productsStartRow);

        // Transpose matrix if necessary
        if (!metadata.getProductAsLines()) {
            matrix.transpose();
        }

        return matrix;
    }
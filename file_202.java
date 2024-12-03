    private void open() {
        if (vcfReader == null) {
            if (indexPath != null) {
                vcfReader = new VCFFileReader(dataPath.toFile(), indexPath.toFile());
            } else {
                vcfReader = new VCFFileReader(dataPath.toFile());
            }
        }
    }
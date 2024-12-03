    public File getOutputHtmlFile() {
        File outFile = new File(
                this.getOutputDirectory() + File.separator + this.getOutputName()
                + "-" + this.reportSuffix() + ".html");
        return outFile;
    }
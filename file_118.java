    public void copySingleFile(File asset) {
        try {
            if ( !asset.isDirectory() ) {
                String targetPath = config.getDestinationFolder().getCanonicalPath() + File.separatorChar + assetSubPath(asset);
                LOGGER.info("Copying single asset file to [{}]", targetPath);
                copyFile(asset, new File(targetPath));
            } else {
                LOGGER.info("Skip copying single asset file [{}]. Is a directory.", asset.getPath());
            }
        } catch (IOException io) {
            LOGGER.error("Failed to copy the asset file.", io);
        }
    }
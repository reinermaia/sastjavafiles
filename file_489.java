    private void unzipNodeModules(File pkgDir) throws IOException {
        File modulesZip = new File(pkgDir + "/node_modules.zip");
        long before = System.currentTimeMillis();
        logger.info("Unzipping " + pkgDir + "/node_modules...");
        ZipHelper.unzip(modulesZip, pkgDir, null, null, Exist.Ignore);
        if (logger.isDebugEnabled())
            logger.debug("  - node_modules unzipped in " + (System.currentTimeMillis() - before) + " ms");
    }
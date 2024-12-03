    private File extract(File compressedFile)
            throws IOException, InterruptedException {
        String fileName = compressedFile.getName().toLowerCase();

        boolean extractFile = !fileName.endsWith("exe")
                && !fileName.endsWith("jar");
        if (extractFile) {
            log.info("Extracting binary from compressed file {}", fileName);
        }
        if (fileName.endsWith("tar.bz2")) {
            unBZip2(compressedFile);
        } else if (fileName.endsWith("tar.gz")) {
            unTarGz(compressedFile);
        } else if (fileName.endsWith("gz")) {
            unGzip(compressedFile);
        } else if (fileName.endsWith("msi")) {
            extractMsi(compressedFile);
        } else if (fileName.endsWith("zip")) {
            unZip(compressedFile);
        }

        if (extractFile) {
            deleteFile(compressedFile);
        }

        File result = WebDriverManager.getInstance(driverManagerType)
                .postDownload(compressedFile).getAbsoluteFile();
        log.trace("Resulting binary file {}", result);

        return result;
    }
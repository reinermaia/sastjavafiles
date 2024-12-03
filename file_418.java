    private void unZip(File compressedFile) throws IOException {
        File file = null;
        try (ZipFile zipFolder = new ZipFile(compressedFile)) {
            Enumeration<?> enu = zipFolder.entries();

            while (enu.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) enu.nextElement();

                String name = zipEntry.getName();
                long size = zipEntry.getSize();
                long compressedSize = zipEntry.getCompressedSize();
                log.trace("Unzipping {} (size: {} KB, compressed size: {} KB)",
                        name, size, compressedSize);

                file = new File(compressedFile.getParentFile(), name);
                if (!file.exists() || config.isOverride()) {
                    if (name.endsWith("/")) {
                        file.mkdirs();
                        continue;
                    }

                    File parent = file.getParentFile();
                    if (parent != null) {
                        parent.mkdirs();
                    }

                    try (InputStream is = zipFolder.getInputStream(zipEntry)) {
                        copyInputStreamToFile(is, file);
                    }
                    setFileExecutable(file);
                } else {
                    log.debug("{} already exists", file);
                }

            }
        }
    }
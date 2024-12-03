    private boolean isBinary() {
        try (InputStream in = getInputStream()) {
            long size = Files.size(file.toPath());
            if (size == 0) {
                // Empty file, so no need to check
                return true;
            }

            byte[] b = new byte[( size < StreamUtils.DEFAULT_PROBE_SIZE ? (int)size : StreamUtils.DEFAULT_PROBE_SIZE)];
            int read = in.read(b);
            if (read != b.length) {
                // Something went wrong, so better not to read line by line
                return true;
            }

            return StreamUtils.isNonWhitespaceControlCharacter(b);
        } catch (IOException e) {
            // If cannot be checked, then considered as binary, so we do not
            // read line by line
            return true;
        }
    }
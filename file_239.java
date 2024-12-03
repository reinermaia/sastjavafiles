    public void save(File file) throws IOException {
        try (FileOutputStream out = new FileOutputStream(file)) {
            save(out);
        }
    }
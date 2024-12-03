    public void save(File file) throws IOException {
        try (FileOutputStream fout = new FileOutputStream(file)) {
            save(fout);
        }
    }
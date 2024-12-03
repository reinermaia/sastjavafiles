    public void replaceFilesWithNewContent(List<String> lines, File file) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        for (int i = 0; i < lines.size(); i++) {
            out.write(lines.get(i));
            out.newLine();
        }
        out.close();
    }
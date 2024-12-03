    public static void zipping(ZipOutputStream zipout, List<File> files, File startDir) {
        FileInputStream in = null;
        byte[] b = new byte[50 * 1024];
        for (int i = 1; i <= files.size(); i++) {
            try {
                File f = files.get(i - 1);
                in = new FileInputStream(f);
                ZipEntry entry = new ZipEntry(f.getAbsolutePath().substring(startDir.getAbsolutePath().length() + 1));
                entry.setMethod(ZipEntry.DEFLATED);
                zipout.putNextEntry(entry);
                IOTools.copy(in, zipout, b);
            } catch (IOException ex) {
                throw Unchecked.rethrow(ex);
            } finally {
                IOTools.close(in);
            }
        }
    }
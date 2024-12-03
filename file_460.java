    public static void copyFile(String originFilePath, String targetFilePath) {
        File originFile = new File(originFilePath);
        File targetFile = new File(targetFilePath);
        copyFile(originFile, targetFile);
    }
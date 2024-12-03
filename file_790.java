    public static void copyToClipboard(String string) {
        ClipboardContent content = new ClipboardContent();
        content.putString(string);
        Clipboard.getSystemClipboard().setContent(content);
        logger.info("copy '" + string + "' to clipboard");
    }
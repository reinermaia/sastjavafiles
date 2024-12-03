    public static String getFromClipboard() throws Exception {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String string = (String) clipboard.getData(DataFlavor.stringFlavor);
        return string;
    }
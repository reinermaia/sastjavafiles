    protected void copyToClipboard(String toolTip) {
        Object[] data = new Object[] { toolTip };
        Transfer[] transfer = new Transfer[] { TextTransfer.getInstance() };
        Clipboard clipboard = new Clipboard(Display.getCurrent());
        clipboard.setContents(data, transfer);
        clipboard.dispose();
    }
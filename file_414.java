    private void copyToClipboard(Context context){
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText(buttonText,inboxMessage.getInboxMessageContents().get(0).getLinkCopyText(buttonObject));
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipData);
            Toast.makeText(context,"Text Copied to Clipboard",Toast.LENGTH_SHORT).show();
        }
    }
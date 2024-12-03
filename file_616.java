    public static String getClipboardText(final Context context) {
        final ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        final ClipData clipData = clipboard.getPrimaryClip();
        if(clipData != null && clipData.getItemCount() > 0) {
            final CharSequence clipboardText = clipData.getItemAt(0).getText();
            if(clipboardText != null) {
                return clipboardText.toString();
            }
        }
        return null;
    }
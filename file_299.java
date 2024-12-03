    public static String encodeTo(String buttonCaption, String html) {
        try {
            return new ExpandableDetailsNote(buttonCaption, html).encode();
        } catch (IOException e) {
            // impossible, but don't make this a fatal problem
            LOGGER.log(Level.WARNING, "Failed to serialize "+HyperlinkNote.class,e);
            return "";
        }
    }
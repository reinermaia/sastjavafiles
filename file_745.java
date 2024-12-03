    public static void forHtmlUnquotedAttribute(Writer out, String input)
        throws IOException
    {
        encode(Encoders.HTML_UNQUOTED_ATTRIBUTE_ENCODER, out, input);
    }
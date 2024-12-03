    public String find(PushbackReader in, int size) throws IOException, SyntaxErrorException
    {
        if (acceptEmpty)
        {
            throw new IllegalArgumentException("using find for  '" + expression + "'  that accepts empty string");
        }
        InputReader reader = Input.getInstance(in, size);
        int rc = find(reader);
        reader.release();
        if (rc == 1)
        {
            return reader.getString();
        }
        else
        {
            throw new SyntaxErrorException("string matching  '" + expression + "'  not found");
        }
    }
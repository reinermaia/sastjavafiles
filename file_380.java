    static public String
    readtextfile(Reader rdr)
            throws IOException
    {
        StringBuilder buf = new StringBuilder();
        for(; ; ) {
            int c = rdr.read();
            if(c < 0) break;
            buf.append((char) c);
        }
        return buf.toString();
    }
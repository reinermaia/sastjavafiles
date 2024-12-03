    public static String urlEncode(String str)
    {
        String ret = str;

        try 
        {
            ret = URLEncoder.encode(str, "UTF-8");
        } 
        catch (UnsupportedEncodingException e) 
        {
            logger.severe("Failed to encode value: "+str);
        }

        return ret;
    }
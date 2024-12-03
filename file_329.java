    public static String encode(String str)
    {
        String encodedValue = str;

        try
        {
            encodedValue = URLEncoder.encode(encodedValue, "UTF-8");

            // Spaces in NRQL queries expected to be encoded as "%20" instead of "+".
            encodedValue = encodedValue.replace("+", "%20");
        }
        catch (UnsupportedEncodingException e)
        {
            logger.severe("Failed to encode value: "+str);
        }

        return encodedValue;
    }
    public static void readErrorResponse(URLConnection c)
    {
        if (c == null)
        {
            return;
        }
        InputStream in = null;
        try
        {
            int error = ((HttpURLConnection) c).getResponseCode();
            in = ((HttpURLConnection) c).getErrorStream();
            if (in == null)
            {
                return;
            }
            LOG.warn("HTTP error response: " + ((HttpURLConnection) c).getResponseMessage());
            // read the response body
            ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
            int count;
            byte[] bytes = new byte[8192];
            while ((count = in.read(bytes)) != -1)
            {
                out.write(bytes, 0, count);
            }
            LOG.warn("HTTP error Code:  " + error);
        }
        catch (ConnectException e)
        {
            LOG.error("Connection exception trying to read HTTP error response", e);
        }
        catch (IOException e)
        {
            LOG.error("IO Exception trying to read HTTP error response", e);
        }
        catch (Exception e)
        {
            LOG.error("Exception trying to read HTTP error response", e);
        }
        finally
        {
            IOUtilities.close(in);
        }
    }
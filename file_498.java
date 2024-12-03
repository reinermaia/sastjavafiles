    private Map<String,String> parseUrlParameters(String urlstring)
        throws MalformedURLException, UnsupportedEncodingException {
        URL url = new URL("http://site/"+urlstring);
        String query = url.getQuery();
        Hashtable<String,String> params = new Hashtable<String,String>();
        if (query!=null) {
            String[] queries = query.split("&");
            for (String q : queries) {
                int k = q.indexOf('=');
                String name, value;
                if (k>0) {
                    name = q.substring(0,k);
                    value = q.substring(k+1);
                } else {
                    name = q;
                    value = "";
                }
                value = java.net.URLDecoder.decode(value, "UTF-8");
    //          System.out.println("   decoded: " + name + "='" + value +"'");
                params.put(name, value);
            }
        }
        return params;
    }
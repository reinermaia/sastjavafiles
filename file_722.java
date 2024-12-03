   	private static JSONObject doPostRequest(HttpPost httpPost, HashMap<String, String> params) throws JSONException {
    	JSONObject json = null;
        HttpClient postClient = HttpClientBuilder.create().build();
        HttpResponse response;
        
        try {
            response = postClient.execute(httpPost);
            
            if(response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                
                if (entity != null) {
                    InputStream instream = entity.getContent();  
                    String result = convertStreamToString(instream);
                    instream.close();
                    
                    json = new JSONObject(result);
                }
            } else {
            	json = UpworkRestClient.genError(response);
            }
        } catch (ClientProtocolException e) {
            json = UpworkRestClient.genError(HTTP_RESPONSE_503, "Exception: ClientProtocolException");
        } catch (IOException e) {
            json = UpworkRestClient.genError(HTTP_RESPONSE_503, "Exception: IOException");
        } catch (JSONException e) {
            json = UpworkRestClient.genError(HTTP_RESPONSE_503, "Exception: JSONException");  
        } catch (Exception e) {
            json = UpworkRestClient.genError(HTTP_RESPONSE_503, "Exception: Exception " + e.toString());
        } finally {
            httpPost.abort();
        }
        
        return json;
    }
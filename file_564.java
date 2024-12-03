    public String jsonToXml(String json){
        String xml = "";
        // 處理直接以陣列開頭的JSON，並指定給予 row 的 tag
        if ( "[".equals( json.substring(0,1) ) ){
            xml = XML.toString(new JSONArray(json), "row");
        }else{
            xml = XML.toString(new JSONObject(json));
        }

        return xml;
    }
	static public JSONObject readJsonObjectFile(File file) throws Exception {
		try {
			JSONObject json = null;
			
			String jsonStr = TextFileUtils.readTextFile(file);
			
			JSONTokener tokener = new JSONTokener(jsonStr);
			Object o = tokener.nextValue();
			if( o instanceof JSONObject ){
				json = (JSONObject)o;
			} else {
				throw new Exception("Unexpected class: "+o.getClass().getName());
			}
			
			// Check that file is empty
			if( tokener.more() ) {
				throw new Exception("File contains more than the object");
			}
			
			return json;

		} catch (Exception e) {
			throw new Exception("Error while parsing JSON Object file: "+file);
		}
	}
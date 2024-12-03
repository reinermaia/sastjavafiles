	public void prettyPrintObject(JSONObject jsonObj, int indentLevel) throws Exception {
		writer.write("{");
		
		Iterator<?> it = jsonObj.keys();
		if( it.hasNext() ) {
			// Accumulate keys
			List<String> keys = new Vector<String>();
			while( it.hasNext() ){
				Object key = it.next();
				if( key instanceof String ){
					keys.add( (String)key );
				}
			}
			
			// Sort keys
			Collections.sort(keys);
			
			// Print out each key
			boolean first = true;
			for(String key : keys){
				Object value = jsonObj.get(key);
				
				// Print indentation
				writer.write("\n");
				for(int i=0,e=indentLevel+1;i<e;++i){
					writer.write(tab);
				}
				
				// Print comma, if needed
				if( first ) {
					first = false;
				} else {
					writer.write(",");
				}
				
				// Print key
				writer.write(JSONObject.quote(key));
				writer.write(":");
				
				// Print value
				prettyPrint(value, indentLevel+1);
			}

			// Print indentation
			writer.write("\n");
			for(int i=0,e=indentLevel;i<e;++i){
				writer.write(tab);
			}
		}

		writer.write("}");
	}
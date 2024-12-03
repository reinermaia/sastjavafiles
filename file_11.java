	private CSVSettings parseCsvSettings(JSONObject headRecord) throws Exception {
		JSONObject csv = headRecord.getJSONObject("_csv");
		
		CSVSettings csvSettings = new CSVSettings();
		
		JSONArray columnArr = csv.getJSONArray("columns");
		for(int i=0,e=columnArr.length(); i<e; ++i){
			Object columnObj = columnArr.get(i);
			if( columnObj instanceof JSONObject ){
				JSONObject jsonColumnDef = (JSONObject)columnObj;
				String name = jsonColumnDef.optString("name",null);
				String label = jsonColumnDef.optString("label",null);
				
				if( null == name ){
					throw new Exception("Column definition must have a name");
				}
				if( null == label ){
					label = name;
				}
				
				CSVColumn csvColumn = new CSVColumn();
				csvColumn.setName(name);
				csvColumn.setLabel(label);
				
				csvSettings.addColumn(csvColumn);
				
			} else {
				throw new Exception("_csv.columns must be array of column definitions (objects)");
			}
		}
		
		return csvSettings;
	}
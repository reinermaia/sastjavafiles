	public static void removeSortColumns(List<String> selectColumns, List<String> sorts, List<Boolean> ascending) {		
		List<String> removedSorts = new ArrayList<String>();	
		for (String sort : sorts) {			
			if (!containsColumnByAlias(selectColumns,sort)) {				
				removedSorts.add(sort);
			}
		}		
		for (String sort : removedSorts) {
			removeSortByColumnName(sorts, ascending, sort);
		}				
	}
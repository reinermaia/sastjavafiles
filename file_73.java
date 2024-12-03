	private void loadSortKeys() {
		// cache sort key so we won't reload it each time
		if(sortKeys != null) return;
		if(orders == null || orders.length == 0) return;
		sortKeys = new ArrayList<List<BSTR>>(orders.length);
		for(SortOrder order: orders) {
			Set<BSTR> sortValues = new HashSet<BSTR>();
			loadSortKey(order.items, 0, sortValues);
			List<BSTR> sortArray = new ArrayList<BSTR>(sortValues);
			Collections.sort(sortArray);
			sortKeys.add(sortArray);
		}
	}
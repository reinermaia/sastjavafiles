	private static String uniqueName(ENamedElement element, String originalName,
			Map<ENamedElement, String> uniqueNameMap) {
		if (uniqueNameMap.containsKey(element)) {
			return uniqueNameMap.get(element);
		}
		String uniqueName = originalName;
		for (int i = 0; RESERVED_KEYWORDS.contains(uniqueName) || RESERVED_RULES.contains(uniqueName.toLowerCase())
				|| element2uniqueName.containsValue(uniqueName)
				|| element2uniqueImplName.containsValue(uniqueName); ++i) {
			uniqueName = originalName + i;
		}
		uniqueNameMap.put(element, uniqueName);
		return uniqueName;
	}
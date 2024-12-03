	public static String uniqueImplName(ENamedElement element) {
		String name = element.getName();
		if (name == null)
			name = element.eClass().getName();
		return uniqueName(element, name + IMPL_NAME_SUFFIX, element2uniqueImplName);
	}
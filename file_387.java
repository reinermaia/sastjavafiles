	@SuppressWarnings("unchecked")
	public JSONNavi<T> array() {
		if (failure)
			return this;
		if (current == null && readonly)
			failure("Can not create Array child in readonly", null);
		if (current != null) {
			if (isArray())
				return this;
			if (isObject())
				failure("can not use Object feature on Array.", null);
			failure("Can not use current possition as Object", null);
		} else {
			current = mapper.createArray();
		}
		if (root == null)
			root = (T) current;
		else
			store();
		return this;
	}
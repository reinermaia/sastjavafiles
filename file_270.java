	public Object doConvert(ConversionContext context, Object sourceObject, TypeReference<?> destinationType) throws ConverterException {
		if (sourceObject == null) {
			if (destinationType.isPrimitive()) {
				throw new ConverterException("Cannot convert null to a primitive number");
			}
			return null;
		}

		String sourceString = (String) sourceObject;

		ParsePosition pos = new ParsePosition(0);
		Number number;
		synchronized(this) {
			number = numberFormat.parse(sourceString, pos);
		}
		if (pos.getIndex() < sourceString.length()) {
			number = null;
		}

		if (number == null) {
			throw new ConverterException(MessageFormat.format(
					"Could not convert ''{0}'' to a number", sourceString));
		}

		return numberToNumberConverter.convert(context, number, destinationType);
	}
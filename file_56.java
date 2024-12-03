	public static void xmlConversionTypeIncorrect(String conversionName,String xmlPath,String className,String type){
		throw new XmlConversionTypeException(MSG.INSTANCE.message(xmlConversionTypeException,conversionName,xmlPath,className,type));
	}
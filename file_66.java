	public Map<String, List<ConversionMethod>> conversionsLoad(){
		Map<String, List<ConversionMethod>> map = new HashMap<String, List<ConversionMethod>>();
		
		try{	// if xml mapping file isn't empty
				if(!isEmpty(xmlJmapper.classes))
					for (XmlClass xmlClass : xmlJmapper.classes) {
					   List<ConversionMethod> conversions = new ArrayList<ConversionMethod>();
					   if(!isEmpty(xmlClass.conversions))
						 for (XmlConversion xmlConversion : xmlClass.conversions)
							 try{	 conversions.add(Converter.toConversionMethod(xmlConversion));
							 }catch (XmlConversionNameException e) {
								 Error.xmlConversionNameUndefined(this.xmlPath,xmlClass.name);
							 }catch (XmlConversionTypeException e) {
								 Error.xmlConversionTypeIncorrect(xmlConversion.name,this.xmlPath,xmlClass.name,xmlConversion.type);
							 }catch (XmlConversionParameterException e) {
								 Error.improperUseOfTheParameter(xmlConversion.name,this.xmlPath,xmlClass.name);
							 }
					   // enrich map only if for this class there are conversions
					   if(!conversions.isEmpty())
						   map.put(xmlClass.name, conversions);
					}
		}catch (Exception e) {JmapperLog.error(e);}
		return map;
	}
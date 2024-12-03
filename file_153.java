public static List<String> getReadOnlyList(String readOnlyName){
	List retList=new ArrayList();
	String readOnlyStr= (String) readOnlyMap.get(readOnlyName);
	if(readOnlyStr!=null){
		String[] tempArray=readOnlyStr.split(",");
		retList=Arrays.asList(tempArray);
	}
	return retList;
}
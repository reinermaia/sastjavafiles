	public static int getOccur(String src,String find){
		int o = 0;
		int index=-1;
		while((index=src.indexOf(find,index))>-1){
			++index;
			++o;
		}
		return o;
	}
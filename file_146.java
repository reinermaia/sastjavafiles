	private int transpositions(String common1,String common2)
	{
		int transpositions = 0;
		for (int i=0; i<common1.length(); i++) {
			if (common1.charAt(i)!=common2.charAt(i)) 
				transpositions++;
		}
		transpositions /= 2;
		return transpositions;
	}
	public int getCoverage1(){
		if ( myResultsSimilarity1 < 0 ) {
			int distance = ca1Length + ca2Length - 2 * getNrEQR();

			int similarity = (ca1Length + ca2Length - distance ) / 2;

			myResultsSimilarity1 = Math.round(similarity /(float) ca1Length * 100);
		}
		return myResultsSimilarity1;
	}
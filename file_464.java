	static int indexOf(byte[] buff, int numBytes, byte[] findBytes, int pos) {
		final int findLen = findBytes.length;
		if(findLen>0) {
			while((pos+findLen)<numBytes) {
				boolean found = true;
				for(int i=0; i < findLen; i++) {
					if(buff[pos+i]!=findBytes[i]) {
						found = false;
						break;
					}
				}
				if(found) return pos;
				pos++;
			}
		}
		return -1;
	}
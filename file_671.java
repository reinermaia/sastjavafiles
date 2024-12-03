	public static byte[] build(String className, String superName) {
		ByteBuffer bb = ByteBuffer.allocate(1000);
		bb.put(BA0_1);
		
		//bb.put(BA2);
		writeUtf8(bb, convertDots(className));
		
		bb.put(BA3);
		
		//bb.put(BA4);
		writeUtf8(bb, convertDots(superName));
		
		bb.put(BA5_12);
		
		//bb.put(BA13);
		writeUtf8(bb, "L" + convertDots(className) + ";");
		
		bb.put(BA14);
		
		//bb.put(BA15);
		String fName = convertDots(className);
		fName = fName.substring(fName.lastIndexOf('/') + 1);
		fName += ".java";
		writeUtf8(bb, fName);
		
		bb.put(BA_end);
		
		byte[] ba = new byte[bb.position()];
		bb.rewind();
		bb.get(ba);
		return ba;
	}
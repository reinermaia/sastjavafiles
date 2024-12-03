    public Object[] readAmf0Array() throws IOException {
        int length = in.readInt();

        Object[] arr = new Object[length];
        for (int i = 0; i < length; i++) {
            arr[i] = decodeAmf0();
        }

        amf0ObjectReferences.add(arr);
        return arr;
    }
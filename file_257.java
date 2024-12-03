    private Object readNewArray(boolean unshared) throws OptionalDataException,
            ClassNotFoundException, IOException {
        ObjectStreamClass classDesc = readClassDesc();

        if (classDesc == null) {
            throw missingClassDescriptor();
        }

        int newHandle = nextHandle();

        // Array size
        int size = input.readInt();
        Class<?> arrayClass = classDesc.forClass();
        Class<?> componentType = arrayClass.getComponentType();
        Object result = Array.newInstance(componentType, size);

        registerObjectRead(result, newHandle, unshared);

        // Now we have code duplication just because Java is typed. We have to
        // read N elements and assign to array positions, but we must typecast
        // the array first, and also call different methods depending on the
        // elements.
        if (componentType.isPrimitive()) {
            if (componentType == int.class) {
                int[] intArray = (int[]) result;
                for (int i = 0; i < size; i++) {
                    intArray[i] = input.readInt();
                }
            } else if (componentType == byte.class) {
                byte[] byteArray = (byte[]) result;
                input.readFully(byteArray, 0, size);
            } else if (componentType == char.class) {
                char[] charArray = (char[]) result;
                for (int i = 0; i < size; i++) {
                    charArray[i] = input.readChar();
                }
            } else if (componentType == short.class) {
                short[] shortArray = (short[]) result;
                for (int i = 0; i < size; i++) {
                    shortArray[i] = input.readShort();
                }
            } else if (componentType == boolean.class) {
                boolean[] booleanArray = (boolean[]) result;
                for (int i = 0; i < size; i++) {
                    booleanArray[i] = input.readBoolean();
                }
            } else if (componentType == long.class) {
                long[] longArray = (long[]) result;
                for (int i = 0; i < size; i++) {
                    longArray[i] = input.readLong();
                }
            } else if (componentType == float.class) {
                float[] floatArray = (float[]) result;
                for (int i = 0; i < size; i++) {
                    floatArray[i] = input.readFloat();
                }
            } else if (componentType == double.class) {
                double[] doubleArray = (double[]) result;
                for (int i = 0; i < size; i++) {
                    doubleArray[i] = input.readDouble();
                }
            } else {
                throw new ClassNotFoundException("Wrong base type in " + classDesc.getName());
            }
        } else {
            // Array of Objects
            Object[] objectArray = (Object[]) result;
            for (int i = 0; i < size; i++) {
                // TODO: This place is the opportunity for enhancement
                //      We can implement writing elements through fast-path,
                //      without setting up the context (see readObject()) for
                //      each element with public API
                objectArray[i] = readObject();
            }
        }
        if (enableResolve) {
            result = resolveObject(result);
            registerObjectRead(result, newHandle, false);
        }
        return result;
    }
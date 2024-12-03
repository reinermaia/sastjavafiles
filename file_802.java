    private int[] fillMissingArray(int[] arrayToExtend) {
        int[] extendedArray = new int[buildNumbers.length];
        System.arraycopy(arrayToExtend, 0, extendedArray, buildNumbers.length - arrayToExtend.length, arrayToExtend.length);
        return extendedArray;
    }
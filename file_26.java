    public static <T extends Comparable<? super T>>  int[] sort(T[] arr) {
        int[] order = new int[arr.length];
        for (int i = 0; i < order.length; i++) {
            order[i] = i;
        }
        sort(arr, order);
        return order;
    }
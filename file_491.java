    public static int[] sort(double[] arr) {
        int[] order = new int[arr.length];
        for (int i = 0; i < order.length; i++) {
            order[i] = i;
        }
        sort(arr, order);
        return order;
    }
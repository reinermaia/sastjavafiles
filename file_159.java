        public static long binCoeff(int n, int k) {
                if (k > n) {
                        return 0;
                }
                if (k == 0 || k == n) {
                        return 1;
                }
                long result = 1;
                for (int i = 1; i <= k; i++) {
                        result *= (n - i + 1) / i;
                }
                return result;
        }
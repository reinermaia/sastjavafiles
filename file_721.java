    private static double scoreToPvalue(double score, int n, double p) {
        /*
        if(n<=20) {
            //calculate it from binomial distribution
        }
        */

        double z=(score+0.5-n*p)/Math.sqrt(n*p*(1.0-p));

        return ContinuousDistributions.gaussCdf(z);
    }
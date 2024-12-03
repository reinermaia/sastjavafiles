    public SDVariable randomBinomial(int nTrials, double p, long... shape) {
        return new BinomialDistribution(sameDiff(), nTrials, p, shape).outputVariable();
    }
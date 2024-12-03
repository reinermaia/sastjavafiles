    public static org.nd4j.linalg.api.rng.distribution.Distribution createDistribution(Distribution dist) {
        if (dist == null)
            return null;
        if (dist instanceof NormalDistribution) {
            NormalDistribution nd = (NormalDistribution) dist;
            return Nd4j.getDistributions().createNormal(nd.getMean(), nd.getStd());
        }
        if (dist instanceof GaussianDistribution) {
            GaussianDistribution nd = (GaussianDistribution) dist;
            return Nd4j.getDistributions().createNormal(nd.getMean(), nd.getStd());
        }
        if (dist instanceof UniformDistribution) {
            UniformDistribution ud = (UniformDistribution) dist;
            return Nd4j.getDistributions().createUniform(ud.getLower(), ud.getUpper());
        }
        if (dist instanceof BinomialDistribution) {
            BinomialDistribution bd = (BinomialDistribution) dist;
            return Nd4j.getDistributions().createBinomial(bd.getNumberOfTrials(), bd.getProbabilityOfSuccess());
        }
        if (dist instanceof LogNormalDistribution) {
            LogNormalDistribution lnd = (LogNormalDistribution) dist;
            return Nd4j.getDistributions().createLogNormal(lnd.getMean(), lnd.getStd());
        }
        if (dist instanceof TruncatedNormalDistribution) {
            TruncatedNormalDistribution tnd = (TruncatedNormalDistribution) dist;
            return Nd4j.getDistributions().createTruncatedNormal(tnd.getMean(), tnd.getStd());
        }
        if (dist instanceof OrthogonalDistribution) {
            OrthogonalDistribution od = (OrthogonalDistribution) dist;
            return Nd4j.getDistributions().createOrthogonal(od.getGain());
        }
        if (dist instanceof ConstantDistribution) {
            ConstantDistribution od = (ConstantDistribution) dist;
            return Nd4j.getDistributions().createConstant(od.getValue());
        }
        throw new RuntimeException("unknown distribution type: " + dist.getClass());
    }
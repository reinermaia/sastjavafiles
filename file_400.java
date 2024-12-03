    public static boolean distributionEquals(IntegerDistribution a, IntegerDistribution b) {
        if (a.getClass() != b.getClass())
            return false;
        Class<?> c = a.getClass();

        if (c == BinomialDistribution.class) {
            BinomialDistribution ba = (BinomialDistribution) a;
            BinomialDistribution bb = (BinomialDistribution) b;
            return ba.getNumberOfTrials() == bb.getNumberOfTrials()
                            && ba.getProbabilityOfSuccess() == bb.getProbabilityOfSuccess();
        } else if (c == GeometricDistribution.class) {
            GeometricDistribution ga = (GeometricDistribution) a;
            GeometricDistribution gb = (GeometricDistribution) b;
            return ga.getProbabilityOfSuccess() == gb.getProbabilityOfSuccess();
        } else if (c == HypergeometricDistribution.class) {
            HypergeometricDistribution ha = (HypergeometricDistribution) a;
            HypergeometricDistribution hb = (HypergeometricDistribution) b;
            return ha.getPopulationSize() == hb.getPopulationSize()
                            && ha.getNumberOfSuccesses() == hb.getNumberOfSuccesses()
                            && ha.getSampleSize() == hb.getSampleSize();
        } else if (c == PascalDistribution.class) {
            PascalDistribution pa = (PascalDistribution) a;
            PascalDistribution pb = (PascalDistribution) b;
            return pa.getNumberOfSuccesses() == pb.getNumberOfSuccesses()
                            && pa.getProbabilityOfSuccess() == pb.getProbabilityOfSuccess();
        } else if (c == PoissonDistribution.class) {
            PoissonDistribution pa = (PoissonDistribution) a;
            PoissonDistribution pb = (PoissonDistribution) b;
            return pa.getMean() == pb.getMean();
        } else if (c == UniformIntegerDistribution.class) {
            UniformIntegerDistribution ua = (UniformIntegerDistribution) a;
            UniformIntegerDistribution ub = (UniformIntegerDistribution) b;
            return ua.getSupportUpperBound() == ub.getSupportUpperBound()
                            && ua.getSupportUpperBound() == ub.getSupportUpperBound();
        } else if (c == ZipfDistribution.class) {
            ZipfDistribution za = (ZipfDistribution) a;
            ZipfDistribution zb = (ZipfDistribution) b;
            return za.getNumberOfElements() == zb.getNumberOfElements() && za.getExponent() == zb.getNumberOfElements();
        } else {
            throw new UnsupportedOperationException("Unknown or not supported IntegerDistribution: " + c);
        }

    }
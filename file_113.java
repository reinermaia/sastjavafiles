    @Override
    public double regress(DataPoint data)
    {
        List<? extends VecPaired<VecPaired<Vec, Integer>, Double>> nearBy = kde.getNearby(data.getNumericalValues());
        if(nearBy.isEmpty())
            return 0;///hmmm... what should be retruned in this case?
        double weightSum = 0;
        double sum = 0;
        
        for(VecPaired<VecPaired<Vec, Integer>, Double> v : nearBy)
        {
            double weight = v.getPair();
            double regressionValue = ( (VecPaired<Vec, Double>) v.getVector().getVector()).getPair();
            weightSum += weight;
            sum += weight*regressionValue;
        }
        
        return sum / weightSum;
    }
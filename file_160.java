    @Override
    public double regress(DataPoint data)
    {
        if(baseRegressor == null)
            throw new RuntimeException("Bagging instance created for classification, not regression");
        else if(learners == null || learners.isEmpty())
            throw new RuntimeException("Regressor has not yet been trained");
        OnLineStatistics stats = new OnLineStatistics();
        for(int i = 0; i < learners.size(); i++)
        {
            double x = ((Regressor) learners.get(i)).regress(data);
            stats.add(x);
        }
        
        return stats.getMean();
    }
    @Override
    public double regress(DataPoint data)
    {
        Vec x = feedForward(data.getNumericalValues());
        
        double val = x.get(0);
        
        val = (val - f.min()-targetBump)/targetMultiplier+targetMin;
        
        return val;
    }
    public static double[] linearReg(double[] xData, double[] yData) {
        sameArrayLen(xData, yData);
        double sumYValue = 0;
        double meanYValue = 0;
        double sumXValue = 0;
        double meanXValue = 0;
        double sumX = 0;
        double sumY = 0;
        double prod = 0;
        double NODATA = -9999;
        int nstat = xData.length;
        double[] regCoef = new double[3]; //(intercept, gradient, r?)
        int counter = 0;
        //calculating sums
        for (int i = 0; i < nstat; i++) {
            if ((yData[i] != NODATA) && (xData[i] != NODATA)) {
                sumYValue += yData[i];
                sumXValue += xData[i];
                counter++;
            }
        }
        //calculating means
        meanYValue = sumYValue / counter;
        meanXValue = sumXValue / counter;

        //calculating regression coefficients
        for (int i = 0; i < nstat; i++) {
            if ((yData[i] != NODATA) && (xData[i] != NODATA)) {
                sumX += Math.pow((xData[i] - meanXValue), 2);
                sumY += Math.pow((yData[i] - meanYValue), 2);
                prod += ((xData[i] - meanXValue) * (yData[i] - meanYValue));
            }
        }
        if (sumX > 0 && sumY > 0) {
            regCoef[1] = prod / sumX;  //gradient
            regCoef[0] = meanYValue - regCoef[1] * meanXValue; //intercept
            regCoef[2] = Math.pow((prod / Math.sqrt(sumX * sumY)), 2); //r?
        } else {
            regCoef[1] = 0;
            regCoef[0] = 0;
            regCoef[2] = 0;
        }
        return regCoef;
    }
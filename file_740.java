    public ScatterPlot points(String id, double[][] data, Color color) {
        if (data[0].length != base.dimension) {
            throw new IllegalArgumentException("Invalid data dimension: " + data[0].length);
        }

        double[] lowerBound = Math.colMin(data);
        double[] upperBound = Math.colMax(data);
        extendBound(lowerBound, upperBound);

        ScatterPlot plot = new ScatterPlot(data);
        plot.setID(id);
        plot.setColor(color);
        add(plot);

        return plot;
    }
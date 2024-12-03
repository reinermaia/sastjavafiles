    public static PlotCanvas plot(String id, double[][] data, int[] y, char[] legend, Color[] palette) {
        if (data[0].length != 2 && data[0].length != 3) {
            throw new IllegalArgumentException("Invalid data dimension: " + data[0].length);
        }

        double[] lowerBound = Math.colMin(data);
        double[] upperBound = Math.colMax(data);
        PlotCanvas canvas = new PlotCanvas(lowerBound, upperBound);

        ScatterPlot plot = new ScatterPlot(data, y, legend, palette);
        plot.setID(id);
        canvas.add(plot);

        return canvas;
    }
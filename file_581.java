    protected PlotCanvas paintOnCanvas(double[][] data, int[] label) {
        PlotCanvas canvas = ScatterPlot.plot(data, pointLegend);
        for (int i = 0; i < data.length; i++) {
            canvas.point(pointLegend, Palette.COLORS[label[i]], data[i]);
        }
        return canvas;
    }
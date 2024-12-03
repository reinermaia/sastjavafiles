    public void addScatterPlot(String scatterID, String xAxisLabel, String yAxisLabel) throws ShanksException {
        if (!this.timeCharts.containsKey(scatterID)) {
            ScatterPlotGenerator scatter = new ScatterPlotGenerator();
            scatter.setTitle(scatterID);
            scatter.setXAxisLabel(xAxisLabel);
            scatter.setYAxisLabel(yAxisLabel);
            this.scatterPlots.put(scatterID, scatter);
        } else {
            throw new DuplicatedChartIDException(scatterID);
        }
    }
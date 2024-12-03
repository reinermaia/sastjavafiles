    public StaircasePlot staircase(String id, double[][] data, Color color) {
        if (data[0].length != 2 && data[0].length != 3) {
            throw new IllegalArgumentException("Invalid data dimension: " + data[0].length);
        }

        StaircasePlot plot = new StaircasePlot(data);
        plot.setID(id);
        plot.setColor(color);
        add(plot);
        return plot;
    }
    public static final void plot(FrequencyDomain fd, double minMag, Path out) throws IOException
    {
        int sampleCount = fd.getSampleCount();
        Plotter plotter = new Plotter(sampleCount, sampleCount/2);
        fd.stream(minMag).forEach((f)->plotter.drawLine(f.getFrequency(), 0, f.getFrequency(), f.getMagnitude()));
        plotter.drawCoordinateX();
        plotter.plot(out.toFile(), "png");
    }
    public static TimeGenerator newTimeGenerator(Map<String, Object> data) {
        String distribution = (String) data.get(SimulationConstants.DISTRIBUTION_TYPE);
         if ("random".equalsIgnoreCase(distribution)) {
            return new RandomTimeGenerator(data);
        } else if ("uniform".equalsIgnoreCase(distribution)) {
            return new UniformTimeGenerator(data);
        } else if ("normal".equalsIgnoreCase(distribution)) {
            return new NormalTimeGenerator(data);
        } else if ("poisson".equalsIgnoreCase(distribution)) {
            return new PoissonTimeGenerator(data);
        } else if ("exact".equalsIgnoreCase(distribution)) {
            return new ExactTimeGenerator(data);
        } else {
            throw new RuntimeException("Unsupported distribution type " + distribution);
        }
    }
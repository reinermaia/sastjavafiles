    public static Timer getStatsTimer(String name) {
        Timer timer = timerMap.get(name);
        if (timer != null) return timer;
        writeLock.lock();
        try {
            if (timerMap.containsKey(name)) {
                return timerMap.get(name);
            } else {
                final StatsConfig statsConfig = new StatsConfig.Builder().withPercentiles(new double[] { 95, 99 })
                        .withPublishMax(true).withPublishMin(true).withPublishMean(true)
                        .withPublishCount(true).withSampleSize(sampleSize.get()).build();
                final MonitorConfig monitorConfig = MonitorConfig.builder(name).withTag(OWNER).build();
                timer = new StatsTimer(monitorConfig, statsConfig, TimeUnit.MILLISECONDS);
                DefaultMonitorRegistry.getInstance().register(timer);
                timerMap.put(name, timer);
                return timer;
            }
        } finally {
            writeLock.unlock();
        }
    }
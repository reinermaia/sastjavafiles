    public static String elapsedTime(String watchName) {
        long elapsed = 0;
        Date start = watchesMap.get(watchName);
        if (start != null) {
            Date end = new Date();
            elapsed = end.getTime() - start.getTime();
        }
        return Long.toString(elapsed);
    }
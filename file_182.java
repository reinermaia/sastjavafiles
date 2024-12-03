    private ZonedDateTime epochToZonedDateTime(final double epochTime) {
        return ZonedDateTime.ofInstant(Instant.ofEpochSecond((long)epochTime), ZoneOffset.UTC);
    }
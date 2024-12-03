    static Double extractLatitude(AisExtractor extractor) {
        int val = extractor.getSignedValue(192, 219);
        if (val == LATITUDE_NOT_AVAILABLE) {
            return null;
        } else {
            Util.checkLat(val / 600000.0);
            return val / 600000.0;
        }
    }
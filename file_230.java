    static Double extractLongitude(AisExtractor extractor) {
        int val = extractor.getSignedValue(164, 192);
        if (val == LONGITUDE_NOT_AVAILABLE) {
            return null;
        } else {
            Util.checkLong(val / 600000.0);
            return val / 600000.0;
        }

    }
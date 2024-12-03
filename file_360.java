    @Procedure
    @Description("apoc.spatial.reverseGeocode(latitude,longitude) YIELD location, latitude, longitude, description - look up address from latitude and longitude from a geocoding service (the default one is OpenStreetMap)")
    public Stream<GeoCodeResult> reverseGeocode(@Name("latitude") double latitude, @Name("longitude") double longitude, @Name(value = "quotaException",defaultValue = "false") boolean quotaException) {
        try {
            return getSupplier().reverseGeocode(latitude, longitude);
        } catch(IllegalStateException re) {
            if (!quotaException && re.getMessage().startsWith("QUOTA_EXCEEDED")) return Stream.empty();
            throw re;
        }
    }
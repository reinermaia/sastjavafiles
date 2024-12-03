    @Nullable
    public String getGpsStatusDescription()
    {
        final String value = _directory.getString(TAG_STATUS);
        if (value == null)
            return null;
        String gpsStatus = value.trim();
        if ("A".equalsIgnoreCase(gpsStatus)) {
            return "Active (Measurement in progress)";
        } else if ("V".equalsIgnoreCase(gpsStatus)) {
            return "Void (Measurement Interoperability)";
        } else {
            return "Unknown (" + gpsStatus + ")";
        }
    }
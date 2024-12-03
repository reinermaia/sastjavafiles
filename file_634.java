  @Implementation
  protected List<Address> getFromLocation(double latitude, double longitude, int maxResults)
      throws IOException {
    Preconditions.checkArgument(
        -90 <= latitude && latitude <= 90, "Latitude must be between -90 and 90, got %s", latitude);
    Preconditions.checkArgument(
        -180 <= longitude && longitude <= 180,
        "Longitude must be between -180 and 180, got %s",
        longitude);
    return fromLocation.subList(0, Math.min(maxResults, fromLocation.size()));
  }
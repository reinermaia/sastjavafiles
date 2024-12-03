    public void addCoordinates(double latitude, double longitude) {
        if (latitude < minimumLatitude) {
            minimumLatitude = latitude;
        }
        if (latitude > maximumLatitude) {
            maximumLatitude = latitude;
        }
        if (longitude < minimumLongitude) {
            minimumLongitude = longitude;
        }
        if (longitude > maximumLongitude) {
            maximumLongitude = longitude;
        }
    }
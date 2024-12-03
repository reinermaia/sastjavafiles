    @Given("^the current Authorization Policy requires a geofence with a radius of (\\d+\\.\\d+), a latitude of (-?\\d+\\.\\d+), and a longitude of (-?\\d+\\.\\d+)$")
    public void theCurrentAuthorizationPolicyRequiresAGeofenceOf(double radius, double latitude, double longitude)
            throws Throwable {
        this.locations.add(new AuthPolicy.Location(radius, latitude, longitude));
    }
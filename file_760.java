    public static LocalLongitude getInstance(double longitude, double latitude)
    {
        if (Math.abs(longitude) < 179)
        {
            return new LocalLongitude(latitude);
        }
        else
        {
            return new PacificLongitude(latitude);
        }
    }
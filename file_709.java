  private String getLatitudeField() throws GeneratorException {
    String lat = latitude.getText();
    if (!lat.matches(LAT_REGEXP)) {
      throw new GeneratorException("Latitude is not a correct value.");
    }
    double val = Double.parseDouble(lat);
    if (val < -90.0 || val > 90.0) {
      throw new GeneratorException("Latitude must be in [-90:90]");
    }
    return lat;
  }
  private TextureData loadTexture(GL2 gl, GLProfile profile, final String filename) {
    try (InputStream stream = ScatterPlot.class.getResourceAsStream(filename)) {
      return TextureIO.newTextureData(profile, stream, false, "png");
    }
    catch(IOException exc) {
      throw new RuntimeException("Could not load texture: " + filename, exc);
    }
  }
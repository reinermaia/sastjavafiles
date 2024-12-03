  protected Binary parseBinary(JsonObject json) throws IOException, FHIRFormatError {
    Binary res = new Binary();
    parseBinaryProperties(json, res);
    return res;
  }
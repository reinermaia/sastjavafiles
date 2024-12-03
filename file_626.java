  protected Base64BinaryType parseBase64Binary(String v) throws IOException, FHIRFormatError {
    Base64BinaryType res = new Base64BinaryType(v);
    return res;
  }
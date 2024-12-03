  protected void getCompressedData() throws IOException {
    checkStream();
  
    int n = in.read(buffer, 0, buffer.length);
    if (n == -1) {
      throw new CodecPrematureEOFException(
          "Unexpected end of input stream, this is typically because of" +
          " truncated compressed file.");
    }

    decompressor.setInput(buffer, 0, n);
  }
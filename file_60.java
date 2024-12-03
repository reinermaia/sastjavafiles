  public Array readCompressedZlib(ucar.nc2.Variable v2, long dataPos, int nx, int ny, int[] origin, int[] shape, int[] stride) throws IOException, InvalidRangeException {

    long length = raf.length();

    raf.seek(dataPos);

    int data_size = (int) (length - dataPos);     //  or 5120 as read buffer size
    byte[] data = new byte[data_size];
    raf.readFully(data);

    // decompress the bytes
    int resultLength;
    int result = 0;
    byte[] tmp;
    int uncompLen;        /* length of decompress space    */
    byte[] uncomp = new byte[nx * (ny + 1) + 4000];
    Inflater inflater = new Inflater(false);

    inflater.setInput(data, 0, data_size);
    int offset = 0;
    int limit = nx * ny + nx;

    while (inflater.getRemaining() > 0) {
      try {
        resultLength = inflater.inflate(uncomp, offset, 4000);

      } catch (DataFormatException ex) {
        ex.printStackTrace();
        throw new IOException(ex.getMessage());
      }

      offset = offset + resultLength;
      result = result + resultLength;
      if ((result) > limit) {
        // when uncomp data larger then limit, the uncomp need to increase size
        tmp = new byte[result];
        System.arraycopy(uncomp, 0, tmp, 0, result);
        uncompLen = result + 4000;
        uncomp = new byte[uncompLen];
        System.arraycopy(tmp, 0, uncomp, 0, result);
      }

      if (resultLength == 0) {
        int tt = inflater.getRemaining();
        byte[] b2 = new byte[2];
        System.arraycopy(data, data_size - tt, b2, 0, 2);
        if (isZlibHed(b2) == 0) {
          System.arraycopy(data, data_size - tt, uncomp, result, tt);
          break;
        }
        inflater.reset();
        inflater.setInput(data, data_size - tt, tt);
      }

    }

    inflater.end();

    byte[] inflateData = new byte[nx * ny];
    System.arraycopy(uncomp, 0, inflateData, 0, nx * ny);
    Array array = Array.factory(DataType.BYTE, v2.getShape(), inflateData);
    if (array.getSize() < Variable.defaultSizeToCache)
      v2.setCachedData(array, false);
    return array.sectionNoReduce(origin, shape, stride);
  }
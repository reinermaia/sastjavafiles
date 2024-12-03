    public static byte[] convertABGRToYUV220SP(BufferedImage image) {
        byte[] oneFrame = new byte[(int) (image.getWidth() * image.getHeight() * 1.5)];
        WritableRaster wr = image.getRaster();
        DataBufferByte db = (DataBufferByte) wr.getDataBuffer();

        byte[] inArray = db.getData();

        int width = wr.getWidth();
        int height = wr.getHeight();

        int i = 0;
        int numpixels = width * height;
        int R, G, B, Y, U, V;
        int ui = numpixels;
        int vi = numpixels + numpixels / 4;
        int color;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int inPtr = (y * width + x) * 4;
                color = image.getRGB(x, y);
                R = inArray[inPtr + 3];
                G = inArray[inPtr + 2];
                B = inArray[inPtr + 1];

                Y = (int) ((0.257 * R) + (0.504 * G) + (0.098 * B) + 16);
                oneFrame[i] = (byte) Y;
                if (0 == y % 2 && 0 == x % 2) {
                    oneFrame[vi++] = (byte) ((0.439 * R) - (0.368 * G) - (0.071 * B) + 128);
                    oneFrame[ui++] = (byte) (-(0.148 * R) - (0.291 * G) + (0.439 * B) + 128);
                }
                i++;
            }
        }
        return oneFrame;
    }
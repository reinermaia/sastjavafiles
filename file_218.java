    private BufferedImage to16Bit1ComponentGrayScale(int[][] decoded, int precision, int width, int height) {
        BufferedImage image;
        if (precision == 16) {
            image = new BufferedImage(width, height, BufferedImage.TYPE_USHORT_GRAY);
        }
        else {
            ColorModel colorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_GRAY), new int[] {precision}, false, false, Transparency.OPAQUE, DataBuffer.TYPE_USHORT);
            image = new BufferedImage(colorModel, colorModel.createCompatibleWritableRaster(width, height), colorModel.isAlphaPremultiplied(), null);
        }

        short[] imageBuffer = ((DataBufferUShort) image.getRaster().getDataBuffer()).getData();

        for (int i = 0; i < imageBuffer.length; i++) {
            imageBuffer[i] = (short) decoded[0][i];
        }

        return image;
    }
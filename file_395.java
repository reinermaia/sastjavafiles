    public static BufferedImage convertImage(RawImage rawImage) {
        switch (rawImage.bpp) {
            case 16:
                return rawImage16toARGB(rawImage);
            case 32:
                return rawImage32toARGB(rawImage);
        }
        return null;
    }
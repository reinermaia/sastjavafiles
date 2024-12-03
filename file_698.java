    private static TextureData readTexture( java.net.URL url, boolean useMipMaps ) {
        try {
            return OGLUtil.newTextureData(Configuration.getMaxCompatibleGLProfile(), url, useMipMaps);
        } catch (Exception e) {
//            String msg = Logging.getMessage("layers.TextureLayer.ExceptionAttemptingToReadTextureFile", url.toString());
//            Logging.logger().log(java.util.logging.Level.SEVERE, msg, e);
            return null;
        }
    }
    private String encodeSendUrl(String encodedChannelUrl) {

        if (Utilities.isSessionEncodedInUrl(encodedChannelUrl, httpConstants.getHTTP_SESSION_ID_NAME())) {
            String channelUrlWithoutSessionId = Utilities.getUrlWithoutSessionId(encodedChannelUrl,
                                                                                 httpConstants.getHTTP_SESSION_ID_NAME());
            String sessionId = Utilities.getSessionId(encodedChannelUrl, httpConstants.getHTTP_SESSION_ID_NAME());

            return Utilities.getSessionEncodedUrl(channelUrlWithoutSessionId + "message/",
                                                  httpConstants.getHTTP_SESSION_ID_NAME(),
                                                  sessionId);

        } else {
            return encodedChannelUrl + "message/";
        }
    }
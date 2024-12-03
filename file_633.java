    @Override
    public void handleErrorResponse(HttpServletResponse response, int httpErrorCode) {
        if (!response.isCommitted()) {
            response.setStatus(httpErrorCode);
        }

        String errorHeader = "HTTP Error 403 - Forbidden";
        if (httpErrorCode != 403) {
            errorHeader = "HTTP Error " + httpErrorCode;
        }

        String errorMessage = Tr.formatMessage(tc, "SOCIAL_LOGIN_FRONT_END_ERROR"); // CWWKS5489E
        writeErrorHtml(response, errorHeader, errorMessage);
    }
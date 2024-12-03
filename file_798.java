    public static boolean isResponseHttpErrorStatus(HttpResponseMessage response) {
        boolean isHttpError = false;
        if (response != null) {
            int status = response.getStatus();
            isHttpError = isResponseHttpErrorStatus(status);
        }
        return isHttpError;
    }
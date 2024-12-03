    @ResponseOverride(
            description = "Return empty response",
            blockRequest = true)
    public static void http_200_empty_response(PluginArguments args) throws Exception {
        HttpServletResponse response = args.getResponse();
        response.setStatus(Constants.statusOK);
        response.setContentType(Constants.contentType);
        PluginHelper.writeResponseContent(response, createErrorMessage(Constants.statusOK, "\"\""));
    }
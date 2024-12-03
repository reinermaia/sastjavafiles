    @RequestMapping(value = "/isPageHtmlAvailable", method = RequestMethod.GET)
    @ResponseBody
    public JsonObject<?> isPageHtmlAvailable(
            @RequestParam(value = "url", required = true) String url) {
        JsonObject<?> result = JsonObject.create();
        LOG.info("Start to get page html of url=" + url);
        try {
            result.addData("isAvailable", StringUtils.isNotEmpty(pageFetcher.getPageHtml(url)));
        } catch (RuntimeException e) {
            LOG.error("Failed to get page html of url=" + url + " due to " + e.getMessage(), e);
            return sysError(GlobalResponseStatusMsg.GET_HTML_PAGE_FAILED.getMessage(url)
                    .getMessage());
        }
        return result;
    }
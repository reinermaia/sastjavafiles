  @Override
  public String getPageHtml(String pageTitle) throws Exception {
    String params = "&page=" + encode(pageTitle);
    Parse parse = getParse(params);
    String html = parse.getText();
    return html;
  }
  public String fixPropertyName(String name) {
    if ("float".equalsIgnoreCase(name)) {
      return "cssFloat";
    } else if ("for".equalsIgnoreCase(name)) {
      return "htmlFor";
    }
    return JsUtils.camelize(name);
  }
  private JsonObject loadJson(InputStream input) throws JsonSyntaxException, IOException {
    return JsonTrackingParser.parse(TextFile.streamToString(input), null);
    // return parser.parse(TextFile.streamToString(input)).getAsJsonObject();
  }
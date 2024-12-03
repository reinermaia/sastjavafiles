  public static JsonObject csvToJsonObject(List<String> bulkRecordHeader, List<String> record, int columnCount) {
    ObjectMapper mapper = new ObjectMapper();
    Map<String, String> resultInfo = new HashMap<>();
    for (int i = 0; i < columnCount; i++) {
      resultInfo.put(bulkRecordHeader.get(i), record.get(i));
    }

    JsonNode json = mapper.valueToTree(resultInfo);
    JsonElement element = GSON.fromJson(json.toString(), JsonObject.class);
    return element.getAsJsonObject();
  }
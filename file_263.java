  @Override
  public ResourceSpecification deserialize(JsonElement json, Type typeOfT,
                                          JsonDeserializationContext context) throws JsonParseException {
    JsonObject jsonObj = json.getAsJsonObject();

    int cores = jsonObj.get("virtualCores").getAsInt();
    int memorySize = jsonObj.get("memoryMB").getAsInt();

    return new Resources(memorySize, cores);
  }
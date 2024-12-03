  @Override
  public EventRequest deserialize(JsonElement json, Type typeOfT,
      JsonDeserializationContext context)
      throws JsonParseException {
    Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create();

    // API versions 2017-05-25 and earlier render `request` as a string
    // instead of a JSON object
    if (json.isJsonPrimitive()) {
      EventRequest request = new EventRequest();
      request.setId(json.getAsString());
      return request;
    } else {
      return gson.fromJson(json, typeOfT);
    }
  }
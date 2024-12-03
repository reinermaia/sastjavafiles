  protected void parseCompartmentDefinitionProperties(JsonObject json, CompartmentDefinition res) throws IOException, FHIRFormatError {
    parseDomainResourceProperties(json, res);
    if (json.has("url"))
      res.setUrlElement(parseUri(json.get("url").getAsString()));
    if (json.has("_url"))
      parseElementProperties(json.getAsJsonObject("_url"), res.getUrlElement());
    if (json.has("name"))
      res.setNameElement(parseString(json.get("name").getAsString()));
    if (json.has("_name"))
      parseElementProperties(json.getAsJsonObject("_name"), res.getNameElement());
    if (json.has("title"))
      res.setTitleElement(parseString(json.get("title").getAsString()));
    if (json.has("_title"))
      parseElementProperties(json.getAsJsonObject("_title"), res.getTitleElement());
    if (json.has("status"))
      res.setStatusElement(parseEnumeration(json.get("status").getAsString(), Enumerations.PublicationStatus.NULL, new Enumerations.PublicationStatusEnumFactory()));
    if (json.has("_status"))
      parseElementProperties(json.getAsJsonObject("_status"), res.getStatusElement());
    if (json.has("experimental"))
      res.setExperimentalElement(parseBoolean(json.get("experimental").getAsBoolean()));
    if (json.has("_experimental"))
      parseElementProperties(json.getAsJsonObject("_experimental"), res.getExperimentalElement());
    if (json.has("date"))
      res.setDateElement(parseDateTime(json.get("date").getAsString()));
    if (json.has("_date"))
      parseElementProperties(json.getAsJsonObject("_date"), res.getDateElement());
    if (json.has("publisher"))
      res.setPublisherElement(parseString(json.get("publisher").getAsString()));
    if (json.has("_publisher"))
      parseElementProperties(json.getAsJsonObject("_publisher"), res.getPublisherElement());
    if (json.has("contact")) {
      JsonArray array = json.getAsJsonArray("contact");
      for (int i = 0; i < array.size(); i++) {
        res.getContact().add(parseContactDetail(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("description"))
      res.setDescriptionElement(parseMarkdown(json.get("description").getAsString()));
    if (json.has("_description"))
      parseElementProperties(json.getAsJsonObject("_description"), res.getDescriptionElement());
    if (json.has("purpose"))
      res.setPurposeElement(parseMarkdown(json.get("purpose").getAsString()));
    if (json.has("_purpose"))
      parseElementProperties(json.getAsJsonObject("_purpose"), res.getPurposeElement());
    if (json.has("useContext")) {
      JsonArray array = json.getAsJsonArray("useContext");
      for (int i = 0; i < array.size(); i++) {
        res.getUseContext().add(parseUsageContext(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("jurisdiction")) {
      JsonArray array = json.getAsJsonArray("jurisdiction");
      for (int i = 0; i < array.size(); i++) {
        res.getJurisdiction().add(parseCodeableConcept(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("code"))
      res.setCodeElement(parseEnumeration(json.get("code").getAsString(), CompartmentDefinition.CompartmentType.NULL, new CompartmentDefinition.CompartmentTypeEnumFactory()));
    if (json.has("_code"))
      parseElementProperties(json.getAsJsonObject("_code"), res.getCodeElement());
    if (json.has("search"))
      res.setSearchElement(parseBoolean(json.get("search").getAsBoolean()));
    if (json.has("_search"))
      parseElementProperties(json.getAsJsonObject("_search"), res.getSearchElement());
    if (json.has("resource")) {
      JsonArray array = json.getAsJsonArray("resource");
      for (int i = 0; i < array.size(); i++) {
        res.getResource().add(parseCompartmentDefinitionCompartmentDefinitionResourceComponent(array.get(i).getAsJsonObject(), res));
      }
    };
  }
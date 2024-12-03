    @Override
    public Document convert(JSONObject json) {
        return JsonXmlConvertHint.convert(json, OsglConfig.xmlRootTag(), OsglConfig.xmlListItemTag());
    }
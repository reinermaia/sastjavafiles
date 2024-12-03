      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Unique identifier for the substance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "A code to indicate if the substance is actively used.", 0, 1, status);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "A code that classifies the general type of substance.  This is used  for searching, sorting and display purposes.", 0, java.lang.Integer.MAX_VALUE, category);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "A code (or set of codes) that identify this substance.", 0, 1, code);
        case -1724546052: /*description*/  return new Property("description", "string", "A description of the substance - its appearance, handling requirements, and other usage notes.", 0, 1, description);
        case 555127957: /*instance*/  return new Property("instance", "", "Substance may be used to describe a kind of substance, or a specific package/container of the substance: an instance.", 0, java.lang.Integer.MAX_VALUE, instance);
        case -206409263: /*ingredient*/  return new Property("ingredient", "", "A substance can be composed of other substances.", 0, java.lang.Integer.MAX_VALUE, ingredient);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }
    private void parseAttDef(String elementName) throws Exception {
        String name;
        String type;
        String enumer = null;

        // Read the attribute name.
        name = readNmtoken(true);

        // Read the attribute type.
        requireWhitespace();
        type = readAttType();

        // Get the string of enumerated values if necessary.
        if (handler.stringInterning) {
            if (("ENUMERATION" == type) || ("NOTATION" == type)) {
                enumer = dataBufferToString();
            }
        } else {
            if ("ENUMERATION".equals(type) || "NOTATION".equals(type)) {
                enumer = dataBufferToString();
            }
        }

        // Read the default value.
        requireWhitespace();
        parseDefault(elementName, name, type, enumer);
    }
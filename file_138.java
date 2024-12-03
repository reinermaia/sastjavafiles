    static String getEnumElementName(XsdEnumeration enumElem) {
        String value = enumElem.getValue();

        if (value.equals("")){
            return "EMPTY";
        }

        if (value.matches("-?\\d*[,|.]?\\d*")){
            return "_" + value;
        }

        return enumElem.getValue().toUpperCase().replaceAll("[^a-zA-Z0-9]", "_");
    }
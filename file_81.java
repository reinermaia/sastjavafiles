    public static String getEnumName(Enum[] e, int value) {
        if (e != null) {
            int toCompareValue;
            for (Enum en : e) {
                if (en instanceof EnumReadable) {
                    toCompareValue = ((EnumReadable) en).value();
                } else {
                    toCompareValue = en.ordinal();
                }
                if (value == toCompareValue) {
                    return en.name();
                }
            }
        }
        return "";
    }
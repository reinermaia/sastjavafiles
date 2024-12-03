    public static <T extends Enum> List<String> getAllEnumNames(Class<T> enumValue) {
        return LinqUtils.select(getAllEnumValuesAsArray(enumValue), EnumUtils::getEnumValue);
    }
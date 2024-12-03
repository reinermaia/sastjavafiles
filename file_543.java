    public boolean isCaseSensitive() {
        switch (getJcrType()) {
            case PropertyType.DOUBLE:
            case PropertyType.LONG:
            case PropertyType.DECIMAL:
            case PropertyType.WEAKREFERENCE:
            case PropertyType.REFERENCE: // conversion is case-insensitive
            case PropertyType.BOOLEAN: // conversion is case-insensitive
                return false;
        }
        return true;
    }
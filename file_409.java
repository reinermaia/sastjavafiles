    public static int convertToInt(Object value)
    {
        if (value instanceof Number)
        {
            return ((Number) value).intValue();
        }
        else if (value instanceof String)
        {
            try
            {
                return Integer.parseInt((String) value);
            }
            catch (NumberFormatException e)
            {
                throw new IllegalArgumentException("Cannot convert " + value.toString() + " to int");
            }
        }
        else
        {
            throw new IllegalArgumentException("Cannot convert " + value.toString() + " to int");
        }
    }
    public static boolean convertToBoolean(Object value)
    {
        if (value instanceof Boolean)
        {
            return ((Boolean) value);
        }
        else if (value instanceof String)
        {
            try
            {
                return Boolean.parseBoolean((String) value);
            }
            catch (Exception e)
            {
                throw new IllegalArgumentException("Cannot convert " + value.toString() + " to boolean");
            }
        }
        else
        {
            throw new IllegalArgumentException("Cannot convert " + value.toString() + " to boolean");
        }
    }    
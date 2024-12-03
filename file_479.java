  public static boolean convertToBoolean(Object o)
  {
    if(o == null)
      return false;

    if(o instanceof Boolean)
    {
      return (Boolean) o;
    }

    return convertToBoolean(o.toString());
  }
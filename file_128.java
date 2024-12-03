  public static String reverse(final String string) {

    return isEmpty(string) ? string : new StringBuilder(string).reverse().toString();
  }
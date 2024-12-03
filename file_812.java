  public static String reverse(String str) {
      if (str == null) {
          return null;
      }
      return new StringBuffer(str).reverse().toString();
  }
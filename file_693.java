   public static boolean isReservedWord(String word)
   {
      return JAVA_KEYWORDS.contains(word) || BOOLEAN_LITERALS.contains(word) || NULL_LITERAL.equals(word);
   }
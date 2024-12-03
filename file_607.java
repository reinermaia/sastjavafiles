  public static String replaceHtmlEntities(String content, Map<String, Character> map) {
    
    for (Entry<String, Character> entry : escapeStrings.entrySet()) {
      
      if (content.indexOf(entry.getKey()) != -1) {
        content = content.replace(entry.getKey(), String.valueOf(entry.getValue()));
      }
      
    }
    
    return content;
  }
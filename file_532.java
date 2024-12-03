  @Nonnull
  private static String extractNote(@Nonnull final Element topic) {
    final StringBuilder result = new StringBuilder();

    for (final Element note : Utils.findDirectChildrenForName(topic, "notes")) {
      final String plain = extractTextContentFrom(note, "plain");
      final String html = extractTextContentFrom(note, "html");

      if (result.length() > 0) {
        result.append('\n');
      }

      if (!plain.isEmpty()) {
        result.append(plain);
      } else if (!html.isEmpty()) {
        result.append(html);
      }
    }

    return result.toString();
  }
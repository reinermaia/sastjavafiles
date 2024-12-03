  private void extract(String htmlDoc) {

    //now extract the contents of <body>...
    int bodyStart = htmlDoc.indexOf(BODY_BEGIN) + BODY_BEGIN.length();

    //scan for end of the <body> start tag (beginning of body content)
    char quote = NOT_IN_QUOTE;
    for (int body = bodyStart; body < htmlDoc.length(); body++) {
      final char c = htmlDoc.charAt(body);
      if (isQuoteChar(c)) {
        if (quote == NOT_IN_QUOTE)
          quote = c;
        else if (quote == c)
          quote = NOT_IN_QUOTE;
      }

      if ('>' == c && NOT_IN_QUOTE == quote) {
        bodyStart = body + 1;
        break;
      }
    }

    int bodyEnd = htmlDoc.indexOf(BODY_END, bodyStart);

    //if there was no body tag, just embed whatever was rendered directly
    if (-1 == bodyEnd) {
      EmbeddedRespond.this.body = htmlDoc;
    } else
      EmbeddedRespond.this.body = htmlDoc.substring(bodyStart, bodyEnd);
  }
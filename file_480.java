  synchronized private static long toEpoch(String dateTime) {
    Date date = null;
    final SimpleDateFormat inputFormat = new SimpleDateFormat(INPUTFORMAT);
    try {
      date = inputFormat.parse(dateTime);
    } catch (ParseException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
    return date.getTime();
  }
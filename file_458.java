  public static Date formatToStartOfDay(final Date date) {

    try {
      SimpleDateFormat dateFormat = buildDateFormat(DEFAULT_DATE_SIMPLE_PATTERN);
      String formattedDate = dateFormat.format(date);
      return dateFormat.parse(formattedDate);
    } catch (ParseException pe) {
      throw new DateException("Unparseable date specified.", pe);
    }
  }
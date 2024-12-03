   private String formatDate(Date value)
   {
      return (value == null ? null : m_formats.getDateFormat().format(value));
   }
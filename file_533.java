    private String formatDate(@NonNull Calendar date) {
        if(customDateFormat == null)
            return DateUtils.formatDateTime(getContext(), date.getTimeInMillis(), DateUtils.FORMAT_SHOW_DATE);
        else
            return customDateFormat.format(date.getTime());
    }
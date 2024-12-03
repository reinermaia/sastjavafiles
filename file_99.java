    @Override
    public Date get()
    {
        String current = supplier.get();
        if ( current != null )
        {
            Date newDate = parseDate(current);
            if ( newDate != null )
            {
                return newDate;
            }
        }
        return defaultValue;
    }
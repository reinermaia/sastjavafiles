    private Date getCurrentDate()
            throws MarshallingError, InvalidResponseException, CommunicationErrorException, CryptographyError,
            InvalidCredentialsException {
        if (serverTimeOffsetExpires == null || serverTimeOffsetExpires.before(new Date())) {
            setServerTimeOffset();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MILLISECOND, serverTimeOffset);
        return calendar.getTime();
    }
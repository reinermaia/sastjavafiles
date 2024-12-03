    private Enum manageEnum(EEnum obj) {
        final Enum e = Enum.of(getFullName(obj));
        obj.getELiterals().stream().forEach(l -> e.addValue(l.getLiteral()));
        return e;
    }